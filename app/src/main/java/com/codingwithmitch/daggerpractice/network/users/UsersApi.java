package com.codingwithmitch.daggerpractice.network.users;

import com.codingwithmitch.daggerpractice.ui.auth.User;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UsersApi {

    // /users/
    @GET("users/{id}")
    Flowable<User> getUser(
            @Path("id") int id
    );

}
