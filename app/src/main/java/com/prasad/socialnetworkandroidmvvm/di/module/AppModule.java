package com.prasad.socialnetworkandroidmvvm.di.module;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prasad.socialnetworkandroidmvvm.BuildConfig;
import com.prasad.socialnetworkandroidmvvm.data.AppDataManager;
import com.prasad.socialnetworkandroidmvvm.data.DataManager;
import com.prasad.socialnetworkandroidmvvm.data.local.db.AppDatabase;
import com.prasad.socialnetworkandroidmvvm.data.local.db.AppDbHelper;
import com.prasad.socialnetworkandroidmvvm.data.local.db.DbHelper;
import com.prasad.socialnetworkandroidmvvm.data.local.prefs.AppPreferencesHelper;
import com.prasad.socialnetworkandroidmvvm.data.local.prefs.PreferencesHelper;
import com.prasad.socialnetworkandroidmvvm.data.remote.ApiHelper;
import com.prasad.socialnetworkandroidmvvm.data.remote.AppApiHelper;
import com.prasad.socialnetworkandroidmvvm.di.ApiInfo;
import com.prasad.socialnetworkandroidmvvm.di.DatabaseInfo;
import com.prasad.socialnetworkandroidmvvm.di.PreferenceInfo;
import com.prasad.socialnetworkandroidmvvm.utils.AppConstants;
import com.prasad.socialnetworkandroidmvvm.utils.rx.AppSchedulerProvider;
import com.prasad.socialnetworkandroidmvvm.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created By Prasad on 2020-05-23.
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @ApiInfo
    String provideAccessToken() {
        return BuildConfig.ACCESS_TOKEN;
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
