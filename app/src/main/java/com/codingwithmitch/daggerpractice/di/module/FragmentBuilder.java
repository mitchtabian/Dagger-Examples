package com.codingwithmitch.daggerpractice.di.module;

import com.codingwithmitch.daggerpractice.ui.PostsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract PostsFragment contributePostsFragment();
}
