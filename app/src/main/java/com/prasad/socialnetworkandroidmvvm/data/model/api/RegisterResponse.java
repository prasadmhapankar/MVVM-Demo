package com.prasad.socialnetworkandroidmvvm.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created By Prasad on 2020-05-25.
 */


public class RegisterResponse {
    @Expose
    @SerializedName("_meta")
    private RegisterResponse.MetaResponse meta;

    @Expose
    @SerializedName("result")
    private RegisterResponse.RegisterResponseResult result;

    public MetaResponse getMeta() {
        return meta;
    }

    public RegisterResponseResult getResult() {
        return result;
    }

    public class RegisterResponseResult{

        @Expose
        @SerializedName("email")
        private String userEmail;

        @Expose
        @SerializedName("id")
        private Long userId;

        @Expose
        @SerializedName("first_name")
        private String firstName;

        @Expose
        @SerializedName("last_name")
        private String lastName;

        public String getUserEmail() {
            return userEmail;
        }

        public Long getUserId() { return userId; }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

    }

    public class MetaResponse {
        @Expose
        @SerializedName("success")
        private Boolean status;
        @Expose
        @SerializedName("message")
        private String message;

        public Boolean getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }
    }
}
