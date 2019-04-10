package com.codingwithmitch.daggerpractice.network.auth;

import com.codingwithmitch.daggerpractice.models.User;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthApi {

    // /users/
    @GET("users/{id}")
    Flowable<User> getUser(
            @Path("id") int id
    );

}
