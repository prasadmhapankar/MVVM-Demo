package com.prasad.socialnetworkandroidmvvm.data.local.prefs;

import com.prasad.socialnetworkandroidmvvm.data.DataManager;

/**
 * Created By Prasad on 2020-05-24.
 */


public interface PreferencesHelper {
    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

    String getCurrentFirstName();

    void setCurrentFirstName(String firstName);

    String getCurrentLastName();

    void setCurrentLastName(String lastName);
}
