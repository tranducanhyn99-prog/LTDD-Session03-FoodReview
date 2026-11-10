package vn.edu.course.foodreview;

import androidx.annotation.NonNull;
import java.util.Objects;

/**
 * Immutable value class representing a restaurant item.
 * Ready for Room (@Entity) in Session 4 and Google Maps (latitude/longitude) in Session 6.
 */
public final class Restaurant {

    private final String id;
    private final String name;
    private final String cuisine;
    private final String district;
    private final String phone;
    private final String address;
    private final double rating;
    private final String description;
    private final double latitude;
    private final double longitude;
    private final boolean favourite;

    public Restaurant(
            @NonNull String id,
            @NonNull String name,
            @NonNull String cuisine,
            @NonNull String district,
            @NonNull String phone,
            @NonNull String address,
            double rating,
            @NonNull String description,
            double latitude,
            double longitude,
            boolean favourite) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.cuisine = Objects.requireNonNull(cuisine, "cuisine must not be null");
        this.district = Objects.requireNonNull(district, "district must not be null");
        this.phone = Objects.requireNonNull(phone, "phone must not be null");
        this.address = Objects.requireNonNull(address, "address must not be null");
        this.rating = rating;
        this.description = Objects.requireNonNull(description, "description must not be null");
        this.latitude = latitude;
        this.longitude = longitude;
        this.favourite = favourite;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getCuisine() {
        return cuisine;
    }

    @NonNull
    public String getDistrict() {
        return district;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    public double getRating() {
        return rating;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean isFavourite() {
        return favourite;
    }

    @NonNull
    public Restaurant withFavourite(boolean newFavourite) {
        return new Restaurant(
                id,
                name,
                cuisine,
                district,
                phone,
                address,
                rating,
                description,
                latitude,
                longitude,
                newFavourite
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant that = (Restaurant) o;
        return Double.compare(that.rating, rating) == 0
                && Double.compare(that.latitude, latitude) == 0
                && Double.compare(that.longitude, longitude) == 0
                && favourite == that.favourite
                && id.equals(that.id)
                && name.equals(that.name)
                && cuisine.equals(that.cuisine)
                && district.equals(that.district)
                && phone.equals(that.phone)
                && address.equals(that.address)
                && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                name,
                cuisine,
                district,
                phone,
                address,
                rating,
                description,
                latitude,
                longitude,
                favourite
        );
    }
}
