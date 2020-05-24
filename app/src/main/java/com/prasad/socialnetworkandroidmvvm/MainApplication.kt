package com.prasad.socialnetworkandroidmvvm

import android.app.Application
import com.prasad.socialnetworkandroidmvvm.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created By Prasad on 2020-05-23.
 */


class MainApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .inject(this)
    }

    /** Returns an [AndroidInjector].  */
    override fun androidInjector(): AndroidInjector<Any> = activityInjector
}