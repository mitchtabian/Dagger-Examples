package com.codingwithmitch.daggerpractice.repositories.posts;

import android.util.Log;


import com.codingwithmitch.daggerpractice.ui.posts.Post;
import com.codingwithmitch.daggerpractice.network.posts.PostsApi;
import com.codingwithmitch.daggerpractice.persistence.posts.PostDao;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import io.reactivex.schedulers.Schedulers;



@Singleton
public class PostsRepository {

    private static final String TAG = "PostsRepository";

    private final PostDao postDao;
    private final PostsApi postsApi;

    @Inject
    public PostsRepository(PostDao postDao, PostsApi postsApi) {
        this.postDao = postDao;
        this.postsApi = postsApi;
        Log.d(TAG, "PostsRepository: Posts repository is working...");
    }


    public LiveData<List<Post>> getPosts(){
        return LiveDataReactiveStreams.fromPublisher(postsApi
                .getPosts()
                .subscribeOn(Schedulers.io()));
    }

}









