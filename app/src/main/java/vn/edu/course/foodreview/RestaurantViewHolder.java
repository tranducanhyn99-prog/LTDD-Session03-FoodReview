package vn.edu.course.foodreview;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;
import vn.edu.course.foodreview.databinding.ItemRestaurantBinding;

/**
 * ViewHolder that caches view references via View Binding and binds a Restaurant row.
 */
public final class RestaurantViewHolder extends RecyclerView.ViewHolder {

    private final ItemRestaurantBinding binding;

    public RestaurantViewHolder(@NonNull ItemRestaurantBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(
            @NonNull Restaurant item,
            @NonNull RestaurantAdapter.OnRestaurantClickListener listener) {
        Context context = binding.getRoot().getContext();
        binding.nameText.setText(item.getName());
        binding.subtitleText.setText(context.getString(
                R.string.cuisine_district_format,
                item.getCuisine(),
                item.getDistrict()
        ));
        binding.ratingText.setText(String.format(
                Locale.getDefault(),
                context.getString(R.string.label_rating),
                item.getRating()
        ));
        binding.favouriteIcon.setVisibility(item.isFavourite() ? View.VISIBLE : View.GONE);
        binding.getRoot().setOnClickListener(v -> listener.onClick(item));
    }
}
