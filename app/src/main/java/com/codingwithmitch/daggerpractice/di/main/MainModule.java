package com.codingwithmitch.daggerpractice.di.main;

import com.codingwithmitch.daggerpractice.network.main.MainApi;
import com.codingwithmitch.daggerpractice.ui.main.posts.PostRecyclerAdapter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @MainScope
    @Provides
    static MainApi provideMainApi(Retrofit retrofit){
        return retrofit.create(MainApi.class);
    }


    @MainScope
    @Provides
    @Named("PostRecyclerAdapter")
    static PostRecyclerAdapter provideAdapter(){
        return new PostRecyclerAdapter();
    }


}



















