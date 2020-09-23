package com.machinetest.app.data.api;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.machinetest.app.data.model.User;
import com.machinetest.app.data.model.UserDao;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    private static UserDatabase INSTANCE;

    public static UserDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "user-database").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        }
        return INSTANCE;
    }
    public static void destroyInstance() {
        INSTANCE = null;
    }
}
