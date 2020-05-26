package com.prasad.socialnetworkandroidmvvm.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created By Prasad on 2020-05-25.
 */


public class PostsResponse {

    @Expose
    @SerializedName("_meta")
    private PostsResponse.MetaResponse meta;

    @Expose
    @SerializedName("result")
    private List<Posts> result;

    public PostsResponse.MetaResponse getMeta() {
        return meta;
    }

    public List<Posts> getResult() {
        return result;
    }

    public static class MetaResponse {
        @Expose
        @SerializedName("success")
        private Boolean status;

        public Boolean getStatus() {
            return status;
        }
    }

    public static class Posts {

        @Expose
        @SerializedName("id")
        private String postId;

        @Expose
        @SerializedName("user_id")
        private String userId;

        @Expose
        @SerializedName("title")
        private String title;

        @Expose
        @SerializedName("body")
        private String body;

        public String getPostId() {
            return postId;
        }

        public String getUserId() {
            return userId;
        }

        public String getTitle() {
            return title;
        }

        public String getBody() {
            return body;
        }
    }
}
