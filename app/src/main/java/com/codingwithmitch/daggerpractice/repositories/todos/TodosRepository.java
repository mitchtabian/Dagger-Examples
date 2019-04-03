package com.codingwithmitch.daggerpractice.repositories.todos;

import android.util.Log;

import com.codingwithmitch.daggerpractice.network.todos.TodosApi;
import com.codingwithmitch.daggerpractice.persistence.todos.TodoDao;
import com.codingwithmitch.daggerpractice.ui.todos.Todo;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import io.reactivex.schedulers.Schedulers;


@Singleton
public class TodosRepository {

    private static final String TAG = "TodosRepository";

    private final TodoDao todoDao;
    private final TodosApi todosApi;

    @Inject
    public TodosRepository(TodoDao todoDao, TodosApi todosApi) {
        this.todoDao = todoDao;
        this.todosApi = todosApi;
        Log.d(TAG, "TodosRepository: Todo repository is working...");
    }


    public LiveData<List<Todo>> getTodos(){
        return LiveDataReactiveStreams.fromPublisher(todosApi
                .getTodos()
                .subscribeOn(Schedulers.io()));
    }

}









