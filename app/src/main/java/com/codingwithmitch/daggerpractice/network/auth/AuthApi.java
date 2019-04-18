package com.codingwithmitch.daggerpractice.network.auth;

import com.codingwithmitch.daggerpractice.models.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthApi {

    // /users/id
    @GET("users/{id}")
    Observable<User> getUser(
            @Path("id") int id
    );
}
