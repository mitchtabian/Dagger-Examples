package com.codingwithmitch.daggerpractice.network.users;

import com.codingwithmitch.daggerpractice.ui.login.User;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UsersApi {

    // /users/
    @GET("users")
    Flowable<User> getUser(
            @Query("id") int id
    );

}
