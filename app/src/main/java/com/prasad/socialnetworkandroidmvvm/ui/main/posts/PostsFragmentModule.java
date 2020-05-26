package com.prasad.socialnetworkandroidmvvm.ui.main.posts;

import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created By Prasad on 2020-05-26.
 */

@Module
public class PostsFragmentModule {
    @Provides
    PostsAdapter providePostsAdapter() {
        return new PostsAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(PostsFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }
}
