package com.prasad.socialnetworkandroidmvvm.data.model.api;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

/**
 * Created By Prasad on 2020-05-24.
 */

@Entity
public class LoginResponse {

    @Expose
    @SerializedName("_meta")
    private MetaResponse meta;

    @Expose
    @SerializedName("result")
    private LoginResponseResult result;

    public LoginResponseResult getResult() {
        return result;
    }

    public MetaResponse getMeta() {
        return meta;
    }

    @Entity
    public class LoginResponseResult{

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

    @Entity
    public class MetaResponse {
        @Expose
        @SerializedName("success")
        private Boolean status;

        public Boolean getStatus() {
            return status;
        }
    }
}
