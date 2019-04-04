package com.codingwithmitch.daggerpractice.network.todos;


import com.codingwithmitch.daggerpractice.ui.main.todos.Todo;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface TodosApi {

    // /todos/
    @GET("todos")
    Flowable<List<Todo>> getTodos();
}



