package com.example.amazinghelpingangels;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemCount = bottomNavigationView.getMenu().size();
                for (int i = 0; i < itemCount; i++){
                    MenuItem menuItem = bottomNavigationView.getMenu().getItem(i);
                    menuItem.setIconTintList(ContextCompat.getColorStateList(MainActivity.this,R.color.unselectedColor));
                }
                //change the color
                item.setIconTintList(ContextCompat.getColorStateList(MainActivity.this,R.color.selectedColor));
                return true;
            }
        });

        //default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }

        //Fragment Applying

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.bottom_nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.bottom_nav_service:
                        selectedFragment = new ServicesFragment();
                        break;

                    case R.id.bottom_nav_News:
                        selectedFragment = new NewsFragment();
                        break;

                    case R.id.bottom_nav_profile:
                        selectedFragment = new ProfileFragment();
                        break;


                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();

                return true;
            }
        });

    }
}