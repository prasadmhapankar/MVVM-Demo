package com.prasad.socialnetworkandroidmvvm.data.local.db;

import com.prasad.socialnetworkandroidmvvm.data.model.db.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created By Prasad on 2020-05-24.
 */

@Singleton
public class AppDbHelper implements DbHelper {

    private final AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return null;
    }

    @Override
    public Observable<Boolean> insertUser(User user) {
        return null;
    }
}
