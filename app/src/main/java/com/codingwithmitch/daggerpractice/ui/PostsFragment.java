package com.codingwithmitch.daggerpractice.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codingwithmitch.daggerpractice.R;
import com.codingwithmitch.daggerpractice.viewmodels.PostsViewModel;
import com.codingwithmitch.daggerpractice.viewmodels.ViewModelProviderFactory;


import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerFragment;

public class PostsFragment extends DaggerFragment {

    private static final String TAG = "PostsFragment";

    @Inject
    ViewModelProviderFactory providerFactory;

    private PostsViewModel viewModel;

    public PostsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = ViewModelProviders.of(this, providerFactory).get(PostsViewModel.class);

        Log.d(TAG, "onViewCreated: PostsFragment is in view.");

        // do stuff
        Toast.makeText(getActivity(), "The fragment is in view", Toast.LENGTH_SHORT).show();
    }
}




























