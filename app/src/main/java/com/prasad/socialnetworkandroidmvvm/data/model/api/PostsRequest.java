package com.prasad.socialnetworkandroidmvvm.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created By Prasad on 2020-05-26.
 */


public class PostsRequest {
    @Expose
    @SerializedName("page")
    private int page;

    public PostsRequest(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }
}
