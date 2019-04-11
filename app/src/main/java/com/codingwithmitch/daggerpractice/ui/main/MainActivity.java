package com.codingwithmitch.daggerpractice.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.codingwithmitch.daggerpractice.BaseActivity;
import com.codingwithmitch.daggerpractice.R;
import com.google.android.material.navigation.NavigationView;


import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.navigation.NavController;

import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "DaggerExample";

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private NavController navController;

//    @Inject
//    @Named("main_string")
//    String someRandomString;

//    @Inject
//    @Named("login_user")
//    User user;

//    @Inject
//    LinearLayoutManager layoutManager;

//    @Inject
//    ProfileFragment profileFragment;
//
//    @Inject
//    PostsFragment postsFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

//        Log.d(TAG, "onCreate: " + someRandomString);
//        Log.d(TAG, "onCreate: authenticated user: " + user.getEmail());

//        Log.d(TAG, "onCreate: layout manger: " + layoutManager);

        Log.d(TAG, "MainActivity: session manager memory location: " + sessionManager);

        init();
    }


    private void init(){
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()){

            case R.id.nav_profile:{

                // nav options to clear backstack
                NavOptions navOptions = new NavOptions.Builder()
                        .setPopUpTo(R.id.main, true)
                        .build();

                Navigation.findNavController(this, R.id.nav_host_fragment)
                        .navigate(R.id.profileScreen,
                                null,
                                navOptions
                        );
                break;
            }

            case R.id.nav_posts:{
                if(isValidDestination(R.id.postsScreen)){
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.postsScreen);
                }
                break;
            }
        }
        menuItem.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    public boolean isValidDestination(int destination){
        return destination != Navigation.findNavController(this, R.id.nav_host_fragment).getCurrentDestination().getId();
    }


    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment), drawerLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
                sessionManager.logOut();
                return true;
            case android.R.id.home:
                if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }
                else{
                    return false;
                }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
}





















