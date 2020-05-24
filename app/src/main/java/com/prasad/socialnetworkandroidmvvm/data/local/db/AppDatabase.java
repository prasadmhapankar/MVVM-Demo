package com.prasad.socialnetworkandroidmvvm.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.prasad.socialnetworkandroidmvvm.data.local.db.dao.UserDao;
import com.prasad.socialnetworkandroidmvvm.data.model.db.User;

/**
 * Created By Prasad on 2020-05-24.
 */

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
