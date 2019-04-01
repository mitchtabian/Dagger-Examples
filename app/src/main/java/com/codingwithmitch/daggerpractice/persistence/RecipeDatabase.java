package com.codingwithmitch.daggerpractice.persistence;


import com.codingwithmitch.daggerpractice.models.Recipe;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Recipe.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class RecipeDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "recipes_db";

    public abstract RecipeDao getRecipeDao();

}






