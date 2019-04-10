package com.codingwithmitch.daggerpractice.di.main;

import com.codingwithmitch.daggerpractice.di.ViewModelKey;
import com.codingwithmitch.daggerpractice.ui.main.posts.PostsViewModel;
import com.codingwithmitch.daggerpractice.ui.main.profile.ProfileViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel.class)
    public abstract ViewModel bindPostsViewModel(PostsViewModel viewModel);
}




