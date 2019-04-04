package com.codingwithmitch.daggerpractice.ui.main.todos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codingwithmitch.daggerpractice.R;
import com.codingwithmitch.daggerpractice.viewmodels.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerFragment;


public class TodosFragment extends DaggerFragment {

    private static final String TAG = "TodosFragment";

    @Inject
    ViewModelProviderFactory providerFactory;

    private TodosViewModel viewModel;

    public TodosFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_todos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = ViewModelProviders.of(this, providerFactory).get(TodosViewModel.class);

        Log.d(TAG, "onViewCreated: TodosFragment is in view.");

        // do stuff
        Toast.makeText(getActivity(), "Todo fragment is in view", Toast.LENGTH_SHORT).show();

        subscribeObservers();
    }

    private void subscribeObservers(){
        Log.d(TAG, "subscribeObservers: subscribing observers.");
        viewModel.getTodos().observe(this, new Observer<List<Todo>>() {
            @Override
            public void onChanged(List<Todo> todos) {
                Log.d(TAG, "onChanged: retrieved " + todos.size() + " todos.");
//                for(Todo todo: todos){
//                    Log.d(TAG, "onChanged: " + todo.getTitle());
//                }
            }
        });
    }

}




























