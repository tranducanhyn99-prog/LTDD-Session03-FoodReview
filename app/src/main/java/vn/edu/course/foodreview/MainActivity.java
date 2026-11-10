package vn.edu.course.foodreview;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import java.util.Arrays;
import java.util.HashSet;
import vn.edu.course.foodreview.databinding.ActivityMainBinding;

/**
 * Single-activity host for the Food Review app (Session 3).
 * Wires MaterialToolbar and BottomNavigationView to the NavHostFragment NavController.
 */
public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavHostFragment host = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host);
        if (host != null) {
            navController = host.getNavController();
            appBarConfiguration = new AppBarConfiguration.Builder(
                    new HashSet<>(Arrays.asList(
                            R.id.restaurantListFragment,
                            R.id.favouritesFragment
                    ))
            ).build();
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            NavigationUI.setupWithNavController(binding.bottomNav, navController);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (navController != null && appBarConfiguration != null) {
            return NavigationUI.navigateUp(navController, appBarConfiguration)
                    || super.onSupportNavigateUp();
        }
        return super.onSupportNavigateUp();
    }
}
