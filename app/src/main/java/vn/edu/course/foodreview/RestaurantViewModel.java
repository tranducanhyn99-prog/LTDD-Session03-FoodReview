package vn.edu.course.foodreview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Shared ViewModel holding restaurant list state in memory across configuration changes
 * and between RestaurantListFragment, FavouritesFragment, and RestaurantDetailFragment.
 */
public class RestaurantViewModel extends ViewModel {

    private final MutableLiveData<List<Restaurant>> restaurantsLiveData =
            new MutableLiveData<>(SampleRestaurants.all());

    @NonNull
    public LiveData<List<Restaurant>> getRestaurants() {
        return restaurantsLiveData;
    }

    @Nullable
    public Restaurant findById(@NonNull String restaurantId) {
        List<Restaurant> current = restaurantsLiveData.getValue();
        if (current != null) {
            for (Restaurant r : current) {
                if (r.getId().equals(restaurantId)) {
                    return r;
                }
            }
        }
        return SampleRestaurants.findById(restaurantId);
    }

    /**
     * Toggles the favourite status of the restaurant with the given ID and emits a new immutable list
     * so ListAdapter + DiffUtil can compute the minimal item update.
     *
     * @return the updated Restaurant, or null if not found
     */
    @Nullable
    public Restaurant toggleFavourite(@NonNull String restaurantId) {
        List<Restaurant> current = restaurantsLiveData.getValue();
        if (current == null) {
            return null;
        }
        List<Restaurant> updatedList = new ArrayList<>(current.size());
        Restaurant updatedTarget = null;
        for (Restaurant item : current) {
            if (item.getId().equals(restaurantId)) {
                updatedTarget = item.withFavourite(!item.isFavourite());
                updatedList.add(updatedTarget);
            } else {
                updatedList.add(item);
            }
        }
        restaurantsLiveData.setValue(Collections.unmodifiableList(updatedList));
        return updatedTarget;
    }
}
