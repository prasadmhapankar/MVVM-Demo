package com.prasad.socialnetworkandroidmvvm.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created By Prasad on 2020-05-24.
 */


public class LoginRequest {

    private LoginRequest() {
        // This class is not publicly instantiable
    }

    public static class ServerLoginRequest {

        @Expose
        @SerializedName("userId")
        private String userId;

        public ServerLoginRequest(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

    }
}
