package com.codingwithmitch.daggerpractice.persistence.todos;

import com.codingwithmitch.daggerpractice.ui.main.todos.Todo;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface TodoDao {

    @Query("SELECT * FROM posts")
    LiveData<List<Todo>> getAllTodos();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTodos(Todo... todos);

}
