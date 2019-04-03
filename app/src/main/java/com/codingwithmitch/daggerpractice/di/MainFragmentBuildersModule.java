package com.codingwithmitch.daggerpractice.di;

import com.codingwithmitch.daggerpractice.ui.posts.PostsFragment;
import com.codingwithmitch.daggerpractice.ui.todos.TodosFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract PostsFragment contributePostsFragment();

    @ContributesAndroidInjector
    abstract TodosFragment contributeTodosFragment();
}
