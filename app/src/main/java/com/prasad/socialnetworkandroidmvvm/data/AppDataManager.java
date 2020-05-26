package com.prasad.socialnetworkandroidmvvm.data;

import android.content.Context;

import com.google.gson.Gson;
import com.prasad.socialnetworkandroidmvvm.data.local.db.DbHelper;
import com.prasad.socialnetworkandroidmvvm.data.local.prefs.PreferencesHelper;
import com.prasad.socialnetworkandroidmvvm.data.model.api.LoginRequest;
import com.prasad.socialnetworkandroidmvvm.data.model.api.LoginResponse;
import com.prasad.socialnetworkandroidmvvm.data.model.api.PostsRequest;
import com.prasad.socialnetworkandroidmvvm.data.model.api.PostsResponse;
import com.prasad.socialnetworkandroidmvvm.data.model.api.RegisterRequest;
import com.prasad.socialnetworkandroidmvvm.data.model.api.RegisterResponse;
import com.prasad.socialnetworkandroidmvvm.data.model.db.User;
import com.prasad.socialnetworkandroidmvvm.data.remote.ApiHelper;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created By Prasad on 2020-05-24.
 */

@Singleton
public class AppDataManager implements DataManager{

    private final ApiHelper mApiHelper;

    private final Context mContext;

    private final DbHelper mDbHelper;

    private final Gson mGson;

    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(Context context, DbHelper dbHelper, PreferencesHelper preferencesHelper, ApiHelper apiHelper, Gson gson) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mGson = gson;
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return mDbHelper.getAllUsers();
    }

    @Override
    public Observable<Boolean> insertUser(User user) {
        return mDbHelper.insertUser(user);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public Long getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public String getCurrentFirstName() {
        return mPreferencesHelper.getCurrentFirstName();
    }

    @Override
    public void setCurrentFirstName(String firstName) {
        mPreferencesHelper.setCurrentFirstName(firstName);
    }

    @Override
    public String getCurrentLastName() {
        return mPreferencesHelper.getCurrentLastName();
    }

    @Override
    public void setCurrentLastName(String lastName) {
        mPreferencesHelper.setCurrentLastName(lastName);
    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return mApiHelper.doServerLoginApiCall(request);
    }

    @Override
    public Single<RegisterResponse> doServerRegisterApiCall(RegisterRequest.ServerRegisterRequest request) {
        return mApiHelper.doServerRegisterApiCall(request);
    }

    @Override
    public Single<PostsResponse> getPostsApiCall(PostsRequest postsRequest) {
        return mApiHelper.getPostsApiCall(postsRequest);
    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(null, LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT, null, null, null);
    }

    @Override
    public void updateUserInfo(Long userId, LoggedInMode loggedInMode, String firstName, String lastName, String email) {
        setCurrentUserId(userId);
        setCurrentUserEmail(email);
        setCurrentUserLoggedInMode(loggedInMode);
        setCurrentFirstName(firstName);
        setCurrentLastName(lastName);
    }
}
