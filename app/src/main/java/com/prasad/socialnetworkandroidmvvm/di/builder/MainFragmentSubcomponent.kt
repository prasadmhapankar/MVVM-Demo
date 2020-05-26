package com.prasad.socialnetworkandroidmvvm.di.builder

import com.prasad.socialnetworkandroidmvvm.ui.main.posts.PostsFragment
import com.prasad.socialnetworkandroidmvvm.ui.main.posts.PostsFragmentModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created By Prasad on 2020-05-26.
 */


@Subcomponent(modules = [PostsFragmentModule::class])
interface MainFragmentSubcomponent: AndroidInjector<PostsFragment> {
    @Subcomponent.Factory
    interface Factory: AndroidInjector.Factory<PostsFragment>
}