package com.codingwithmitch.daggerpractice.di;

import com.codingwithmitch.daggerpractice.ui.posts.PostsViewModel;
import com.codingwithmitch.daggerpractice.ui.todos.TodosViewModel;
import com.codingwithmitch.daggerpractice.viewmodels.ViewModelProviderFactory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap // multibinding
    @ViewModelKey(PostsViewModel.class)
    public abstract ViewModel bindPostsViewModel(PostsViewModel viewModel);

    @Binds
    @IntoMap // multibinding
    @ViewModelKey(TodosViewModel.class)
    public abstract ViewModel bindTodosViewModel(TodosViewModel viewModel);

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelFactory);

}