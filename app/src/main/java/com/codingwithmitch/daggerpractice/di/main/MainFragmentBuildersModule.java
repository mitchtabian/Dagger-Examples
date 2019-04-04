package com.codingwithmitch.daggerpractice.di.main;

import com.codingwithmitch.daggerpractice.ui.main.posts.PostsFragment;
import com.codingwithmitch.daggerpractice.ui.main.todos.TodosFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract PostsFragment contributePostsFragment();

    @ContributesAndroidInjector
    abstract TodosFragment contributeTodosFragment();
}
