package com.prasad.socialnetworkandroidmvvm.data.local.db;

import com.prasad.socialnetworkandroidmvvm.data.model.db.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created By Prasad on 2020-05-24.
 */


public interface DbHelper {

    Observable<List<User>> getAllUsers();

    Observable<Boolean> insertUser(final User user);
}
