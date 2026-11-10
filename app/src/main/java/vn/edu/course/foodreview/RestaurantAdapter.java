package vn.edu.course.foodreview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import vn.edu.course.foodreview.databinding.ItemRestaurantBinding;

/**
 * ListAdapter backed by DiffUtil.ItemCallback as required by Session 3 Slides 13-15 & 42.
 * Updates are submitted exclusively via submitList(...), never notifyDataSetChanged().
 */
public final class RestaurantAdapter extends ListAdapter<Restaurant, RestaurantViewHolder> {

    public interface OnRestaurantClickListener {
        void onClick(@NonNull Restaurant restaurant);
    }

    private static final DiffUtil.ItemCallback<Restaurant> DIFF =
            new DiffUtil.ItemCallback<Restaurant>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull Restaurant oldItem,
                        @NonNull Restaurant newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }

                @Override
                public boolean areContentsTheSame(
                        @NonNull Restaurant oldItem,
                        @NonNull Restaurant newItem) {
                    return oldItem.equals(newItem);
                }
            };

    private final OnRestaurantClickListener listener;

    public RestaurantAdapter(@NonNull OnRestaurantClickListener listener) {
        super(DIFF);
        this.listener = listener;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRestaurantBinding binding = ItemRestaurantBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new RestaurantViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        holder.bind(getItem(position), listener);
    }
}
