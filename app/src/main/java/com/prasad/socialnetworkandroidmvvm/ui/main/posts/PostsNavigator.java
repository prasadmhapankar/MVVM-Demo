package com.prasad.socialnetworkandroidmvvm.ui.main.posts;

import com.prasad.socialnetworkandroidmvvm.data.model.api.PostsResponse;

import java.util.List;

/**
 * Created By Prasad on 2020-05-25.
 */


public interface PostsNavigator {
    void handleError(Throwable throwable);

    void updatePosts(List<PostsResponse.Posts> postsList);
}
