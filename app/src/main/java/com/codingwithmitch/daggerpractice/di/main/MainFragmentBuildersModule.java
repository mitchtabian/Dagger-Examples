package com.codingwithmitch.daggerpractice.di.main;

import com.codingwithmitch.daggerpractice.BaseActivity;
import com.codingwithmitch.daggerpractice.ui.main.posts.PostsFragment;
import com.codingwithmitch.daggerpractice.ui.main.profile.ProfileFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector
    abstract PostsFragment contributePostsFragment();
}
