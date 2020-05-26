package com.prasad.socialnetworkandroidmvvm.ui.main.posts;

import androidx.databinding.ObservableField;

import com.prasad.socialnetworkandroidmvvm.data.model.api.PostsResponse;

/**
 * Created By Prasad on 2020-05-26.
 */


public class PostsItemViewModel {

    private final PostsResponse.Posts mPost;

    public final PostsItemViewModelListener mListener;

    public final ObservableField<String> title;

    public final ObservableField<String> body;

    public PostsItemViewModel(PostsResponse.Posts post, PostsItemViewModelListener listener) {
        this.mPost = post;
        this.mListener = listener;
        title = new ObservableField<>(mPost.getTitle());
        body = new ObservableField<>(mPost.getBody());
    }

    public void onItemClick() {
        mListener.onItemClick();
    }

    public interface PostsItemViewModelListener {
        void onItemClick();
    }
}
