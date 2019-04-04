package com.codingwithmitch.daggerpractice.ui.main.posts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codingwithmitch.daggerpractice.R;
import com.codingwithmitch.daggerpractice.viewmodels.ViewModelProviderFactory;


import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.lifecycle.Observer;
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
        Toast.makeText(getActivity(), "Posts fragment is in view", Toast.LENGTH_SHORT).show();

        subscribeObservers();
    }

    private void subscribeObservers(){
        Log.d(TAG, "subscribeObservers: subscribing observers.");
        viewModel.getPosts().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                Log.d(TAG, "onChanged: retrieved " + posts.size() + " posts.");
//                for(Post post: posts){
//                    Log.d(TAG, "onChanged: " + post.getTitle());
//                }
            }
        });
    }
}




























