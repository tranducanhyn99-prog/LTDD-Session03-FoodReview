package vn.edu.course.foodreview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import vn.edu.course.foodreview.databinding.FragmentRestaurantListBinding;

/**
 * Displays the full list of sample restaurants in a RecyclerView and navigates to
 * RestaurantDetailFragment using Safe Args (passing only restaurantId).
 */
public class RestaurantListFragment extends Fragment {

    @Nullable
    private FragmentRestaurantListBinding binding;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        binding = FragmentRestaurantListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentRestaurantListBinding b = binding;
        if (b == null) return;

        int columns = getResources().getInteger(R.integer.restaurant_columns);
        b.restaurantList.setLayoutManager(new GridLayoutManager(requireContext(), columns));

        RestaurantAdapter adapter = new RestaurantAdapter(restaurant -> {
            NavDirections action = RestaurantListFragmentDirections
                    .actionListToDetail(restaurant.getId());
            NavHostFragment.findNavController(this).navigate(action);
        });
        b.restaurantList.setAdapter(adapter);

        RestaurantViewModel viewModel = new ViewModelProvider(requireActivity())
                .get(RestaurantViewModel.class);
        viewModel.getRestaurants().observe(getViewLifecycleOwner(), restaurants -> {
            adapter.submitList(restaurants);
            b.emptyText.setVisibility(
                    restaurants == null || restaurants.isEmpty() ? View.VISIBLE : View.GONE
            );
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
