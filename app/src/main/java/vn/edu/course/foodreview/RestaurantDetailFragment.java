package vn.edu.course.foodreview;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.snackbar.Snackbar;
import java.util.Locale;
import vn.edu.course.foodreview.databinding.FragmentRestaurantDetailBinding;

/**
 * Detail screen that receives restaurantId via Safe Args, looks up the Restaurant,
 * displays its details, and provides Call (ACTION_DIAL), Favourite toggle, and Share actions.
 */
public class RestaurantDetailFragment extends Fragment {

    @Nullable
    private FragmentRestaurantDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        binding = FragmentRestaurantDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentRestaurantDetailBinding b = binding;
        if (b == null) return;

        RestaurantDetailFragmentArgs args =
                RestaurantDetailFragmentArgs.fromBundle(requireArguments());
        String restaurantId = args.getRestaurantId();

        RestaurantViewModel viewModel = new ViewModelProvider(requireActivity())
                .get(RestaurantViewModel.class);

        viewModel.getRestaurants().observe(getViewLifecycleOwner(), restaurants -> {
            Restaurant restaurant = viewModel.findById(restaurantId);
            if (restaurant != null) {
                bindRestaurant(b, restaurant, viewModel);
            }
        });
    }

    private void bindRestaurant(
            @NonNull FragmentRestaurantDetailBinding b,
            @NonNull Restaurant restaurant,
            @NonNull RestaurantViewModel viewModel) {
        b.detailNameText.setText(restaurant.getName());
        b.detailRatingText.setText(String.format(
                Locale.getDefault(),
                getString(R.string.label_rating),
                restaurant.getRating()
        ));
        b.detailCuisineText.setText(getString(R.string.label_cuisine, restaurant.getCuisine()));
        b.detailDistrictText.setText(getString(R.string.label_district, restaurant.getDistrict()));
        b.detailAddressText.setText(getString(R.string.label_address, restaurant.getAddress()));
        b.detailPhoneText.setText(getString(R.string.label_phone, restaurant.getPhone()));
        b.detailDescriptionText.setText(restaurant.getDescription());

        if (restaurant.isFavourite()) {
            b.favouriteButton.setText(R.string.action_favourite_remove);
            b.favouriteButton.setIconResource(R.drawable.ic_favorite);
        } else {
            b.favouriteButton.setText(R.string.action_favourite_add);
            b.favouriteButton.setIconResource(R.drawable.ic_favorite_border);
        }

        b.callButton.setOnClickListener(v -> dialPhone(restaurant.getPhone()));

        b.favouriteButton.setOnClickListener(v -> {
            Restaurant updated = viewModel.toggleFavourite(restaurant.getId());
            if (updated != null && binding != null) {
                int msgRes = updated.isFavourite()
                        ? R.string.added_to_favourites
                        : R.string.removed_from_favourites;
                Snackbar.make(
                        binding.getRoot(),
                        getString(msgRes, updated.getName()),
                        Snackbar.LENGTH_SHORT
                ).show();
            }
        });

        b.shareButton.setOnClickListener(v -> shareRestaurant(restaurant));
    }

    /**
     * Opens the system phone dialler with the number pre-filled using Intent.ACTION_DIAL
     * and Uri.fromParts("tel", phone, null) as required on Slide 33 & 40.
     * No CALL_PHONE permission is required.
     */
    private void dialPhone(@NonNull String phone) {
        Uri number = Uri.fromParts("tel", phone, null);
        Intent intent = new Intent(Intent.ACTION_DIAL, number);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            if (binding != null) {
                Snackbar.make(binding.getRoot(), R.string.no_dialler, Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    private void shareRestaurant(@NonNull Restaurant restaurant) {
        String shareBody = getString(
                R.string.share_restaurant_text,
                restaurant.getName(),
                restaurant.getCuisine(),
                restaurant.getDistrict(),
                restaurant.getAddress(),
                restaurant.getPhone()
        );
        Intent send = new Intent(Intent.ACTION_SEND);
        send.setType("text/plain");
        send.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(send, getString(R.string.action_share)));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
