package com.prasad.socialnetworkandroidmvvm.utils;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.prasad.socialnetworkandroidmvvm.data.model.api.PostsResponse;
import com.prasad.socialnetworkandroidmvvm.ui.main.posts.PostsAdapter;

import java.util.List;

/**
 * Created By Prasad on 2020-05-26.
 */


public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter"})
    public static void addPostsItems(RecyclerView recyclerView, List<PostsResponse.Posts> posts) {
        PostsAdapter adapter = (PostsAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(posts);
        }
    }
}
