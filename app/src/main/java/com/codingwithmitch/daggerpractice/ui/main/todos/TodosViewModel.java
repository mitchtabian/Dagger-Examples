package com.codingwithmitch.daggerpractice.ui.main.todos;

import android.util.Log;

import com.codingwithmitch.daggerpractice.repositories.todos.TodosRepository;
import com.codingwithmitch.daggerpractice.ui.main.posts.Post;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class TodosViewModel extends ViewModel {

    private static final String TAG = "TodosViewModel";

    private final TodosRepository repository;

    @Inject
    public TodosViewModel(TodosRepository repository) {
        this.repository = repository;
        Log.d(TAG, "view model is working...");
    }


    public LiveData<List<Todo>> getTodos(){
        return repository.getTodos();
    }

}















