package com.codingwithmitch.daggerpractice.di;

import android.app.Application;

import com.codingwithmitch.daggerpractice.network.posts.PostsApi;
import com.codingwithmitch.daggerpractice.network.todos.TodosApi;
import com.codingwithmitch.daggerpractice.persistence.AppDatabase;
import com.codingwithmitch.daggerpractice.persistence.posts.PostDao;
import com.codingwithmitch.daggerpractice.persistence.todos.TodoDao;
import com.codingwithmitch.daggerpractice.util.Constants;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


import static com.codingwithmitch.daggerpractice.persistence.AppDatabase.DATABASE_NAME;

@Module
public class AppModule {

    @Singleton
    @Provides
    static AppDatabase provideAppDatabase(Application application){
        return Room.databaseBuilder(
                application,
                AppDatabase.class,
                DATABASE_NAME
        ).build();
    }

    @Singleton
    @Provides
    static PostDao providePostsDao(AppDatabase db){
        return db.getPostsDao();
    }

    @Singleton
    @Provides
    static TodoDao provideTodosDao(AppDatabase db){
        return db.getTodosDao();
    }

    @Singleton
    @Provides
    static Retrofit provideRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    @Singleton
    @Provides
    static PostsApi providePostsApi(Retrofit retrofit){
        return retrofit.create(PostsApi.class);
    }

    @Singleton
    @Provides
    static TodosApi provideTodosApi(Retrofit retrofit){
        return retrofit.create(TodosApi.class);
    }

}



















