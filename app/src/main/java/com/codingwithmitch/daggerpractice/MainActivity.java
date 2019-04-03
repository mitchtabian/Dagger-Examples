package com.codingwithmitch.daggerpractice;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.codingwithmitch.daggerpractice.ui.posts.PostsFragment;
import com.codingwithmitch.daggerpractice.ui.todos.TodosFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public ProgressBar progressBar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress_bar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        init();
    }

    private void init(){
        loadFragment(new PostsFragment());
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    public void showProgressBar(boolean visibility){
        progressBar.setVisibility(visibility ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()){

            case R.id.nav_posts:{
                loadFragment(new PostsFragment());
                break;
            }

            case R.id.nav_todos:{
                loadFragment(new TodosFragment());
                break;
            }
        }

        menuItem.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    public void loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .commit();
        }
    }

}
