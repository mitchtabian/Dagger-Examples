package com.codingwithmitch.daggerpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.codingwithmitch.daggerpractice.viewmodels.MainViewModel;
import com.codingwithmitch.daggerpractice.viewmodels.ViewModelProviderFactory;


import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


    @Inject
    ViewModelProviderFactory providerFactory;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		
		AndroidInjection.inject(this);
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this, providerFactory).get(MainViewModel.class);
    }

}













