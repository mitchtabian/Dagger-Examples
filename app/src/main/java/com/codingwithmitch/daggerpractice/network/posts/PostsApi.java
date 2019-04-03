package com.codingwithmitch.daggerpractice.network.posts;

import com.codingwithmitch.daggerpractice.ui.posts.Post;


import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface PostsApi {

    // /posts/
    @GET("posts")
    Flowable<List<Post>> getPosts();

}
