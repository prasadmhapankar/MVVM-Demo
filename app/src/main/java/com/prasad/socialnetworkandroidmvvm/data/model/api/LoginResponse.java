package com.prasad.socialnetworkandroidmvvm.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created By Prasad on 2020-05-24.
 */


public class LoginResponse {
    @Expose
    @SerializedName("email")
    private String userEmail;

    @Expose
    @SerializedName("user_id")
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

    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
