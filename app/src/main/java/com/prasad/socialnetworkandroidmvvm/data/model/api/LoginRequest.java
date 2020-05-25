package com.prasad.socialnetworkandroidmvvm.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

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

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }

            ServerLoginRequest that = (ServerLoginRequest) object;

            return Objects.equals(userId, that.userId);
        }

        @Override
        public int hashCode() {
            int result = userId != null ? userId.hashCode() : 0;
            return result;
        }

        public String getUserId() {
            return userId;
        }

    }
}
