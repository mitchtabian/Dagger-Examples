package com.codingwithmitch.daggerpractice.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.codingwithmitch.daggerpractice.BaseActivity;
import com.codingwithmitch.daggerpractice.BaseApplication;
import com.codingwithmitch.daggerpractice.R;
import com.codingwithmitch.daggerpractice.ui.main.posts.PostsFragment;
import com.codingwithmitch.daggerpractice.ui.main.profile.ProfileFragment;
import com.google.android.material.navigation.NavigationView;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "DaggerExample";

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

//    @Inject
//    @Named("main_string")
//    String someRandomString;

//    @Inject
//    @Named("login_user")
//    User user;

//    @Inject
//    LinearLayoutManager layoutManager;

    @Inject
    ProfileFragment profileFragment;

    @Inject
    PostsFragment postsFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        setTitle("Main Scope");

        navigationView.setNavigationItemSelectedListener(this);

//        Log.d(TAG, "onCreate: " + someRandomString);
//        Log.d(TAG, "onCreate: authenticated user: " + user.getEmail());

//        Log.d(TAG, "onCreate: layout manger: " + layoutManager);

        Log.d(TAG, "MainActivity: session manager memory location: " + sessionManager);
        init();
    }

    private void init(){
        Log.d(TAG, "init: " + profileFragment);
        // do not add first fragment to backstack
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, profileFragment, getString(R.string.fragment_profile))
                .commit();

        navigationView.getMenu().getItem(0).setChecked(true);
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()){

            case R.id.nav_posts:{
                loadFragment(postsFragment, getString(R.string.fragment_posts));
                break;
            }

            case R.id.nav_profile:{
                loadFragment(profileFragment, getString(R.string.fragment_profile));
                break;
            }
        }

        menuItem.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    // adds to backstack
    public void loadFragment(Fragment fragment, String name) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(name)
                    .replace(R.id.main_container, fragment)
                    .commit();
        }
    }
}





















