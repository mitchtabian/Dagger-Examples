package com.codingwithmitch.daggerpractice.di.module;

import android.app.Application;

import com.codingwithmitch.daggerpractice.persistence.AppDatabase;
import com.codingwithmitch.daggerpractice.persistence.PostDao;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

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
    static PostDao provideRecipeDao(AppDatabase db){
        return db.getPostsDao();
    }

}



