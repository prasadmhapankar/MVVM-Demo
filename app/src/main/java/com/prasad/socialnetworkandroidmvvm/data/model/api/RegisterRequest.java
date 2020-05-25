package com.prasad.socialnetworkandroidmvvm.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created By Prasad on 2020-05-25.
 */


public class RegisterRequest {

    public static class ServerRegisterRequest {

        @Expose
        @SerializedName("first_name")
        private String firstName;
        @Expose
        @SerializedName("last_name")
        private String lastName;
        @Expose
        @SerializedName("email")
        private String email;
        @Expose
        @SerializedName("gender")
        private String gender;

        public ServerRegisterRequest(String firstName, String lastName, String email, String gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.gender = gender;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getGender() {
            return gender;
        }
    }

}
