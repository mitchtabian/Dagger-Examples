package com.codingwithmitch.daggerpractice.di;

import com.codingwithmitch.daggerpractice.ui.main.posts.PostsViewModel;
import com.codingwithmitch.daggerpractice.ui.main.profile.ProfileViewModel;
import com.codingwithmitch.daggerpractice.viewmodels.ViewModelProviderFactory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelFactory);
}
