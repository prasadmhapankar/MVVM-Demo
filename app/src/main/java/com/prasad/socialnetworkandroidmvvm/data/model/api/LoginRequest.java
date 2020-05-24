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
        @SerializedName("email")
        private String email;

        @Expose
        @SerializedName("password")
        private String password;

        public ServerLoginRequest(String email, String password) {
            this.email = email;
            this.password = password;
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

            if (!Objects.equals(email, that.email)) {
                return false;
            }
            return Objects.equals(password, that.password);
        }

        @Override
        public int hashCode() {
            int result = email != null ? email.hashCode() : 0;
            result = 31 * result + (password != null ? password.hashCode() : 0);
            return result;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }
}
