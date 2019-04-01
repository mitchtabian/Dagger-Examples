package com.codingwithmitch.daggerpractice.di.module;

import android.app.Application;

import com.codingwithmitch.daggerpractice.persistence.RecipeDao;
import com.codingwithmitch.daggerpractice.persistence.RecipeDatabase;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

import static com.codingwithmitch.daggerpractice.persistence.RecipeDatabase.DATABASE_NAME;

@Module
public class AppModule {

    @Singleton
    @Provides
    static RecipeDatabase provideRecipeDatabase(Application application){
        return Room.databaseBuilder(
                application,
                RecipeDatabase.class,
                DATABASE_NAME
        ).build();
    }

    @Singleton
    @Provides
    static RecipeDao provideRecipeDao(RecipeDatabase db){
        return db.getRecipeDao();
    }

}



