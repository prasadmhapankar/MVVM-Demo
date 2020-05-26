package com.prasad.socialnetworkandroidmvvm.ui.main.posts;

/**
 * Created By Prasad on 2020-05-26.
 */


public class PostsEmptyItemViewModel {

    private PostsEmptyItemViewModelListener mListener;

    public PostsEmptyItemViewModel(PostsEmptyItemViewModelListener listener) {
        this.mListener = listener;
    }

    public void onRetryClick() {
        mListener.onRetryClick();
    }

    public interface PostsEmptyItemViewModelListener {
        void onRetryClick();
    }
}
