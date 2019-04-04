package com.codingwithmitch.daggerpractice.ui.main.posts;

import android.util.Log;

import com.codingwithmitch.daggerpractice.repositories.posts.PostsRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class PostsViewModel extends ViewModel {

    private static final String TAG = "PostsViewModel";

    private final PostsRepository repository;

    @Inject
    public PostsViewModel(PostsRepository repository) {
        this.repository = repository;
        Log.d(TAG, "view model is working...");
    }

    public LiveData<List<Post>> getPosts(){
        return repository.getPosts();
    }

}















