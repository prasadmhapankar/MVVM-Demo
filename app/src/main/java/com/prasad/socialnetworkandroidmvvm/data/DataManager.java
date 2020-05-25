package com.prasad.socialnetworkandroidmvvm.data;

import com.prasad.socialnetworkandroidmvvm.data.local.db.DbHelper;
import com.prasad.socialnetworkandroidmvvm.data.local.prefs.PreferencesHelper;
import com.prasad.socialnetworkandroidmvvm.data.remote.ApiHelper;

/**
 * Created By Prasad on 2020-05-23.
 */


public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {

    void setUserAsLoggedOut();

    void updateUserInfo(
            Long userId,
            LoggedInMode loggedInMode,
            String firstName,
            String lastName,
            String email);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_SERVER(1);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
