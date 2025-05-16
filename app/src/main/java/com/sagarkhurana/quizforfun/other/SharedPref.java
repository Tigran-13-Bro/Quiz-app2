package com.sagarkhurana.quizforfun.other;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.sagarkhurana.quizforfun.data.User;

public class SharedPref {

    private static SharedPref instance = null;

    private static final String sharedPreferencesName = "kevinSharedPref";
    private static final String KEY_IS_GUEST = "is_guest"; // New key for guest mode

    private SharedPref() {
    }

    public static SharedPref getInstance() {
        if (instance == null) {
            instance = new SharedPref();
        }
        return instance;
    }

    public void setUser(Context context, User user) {
        SharedPreferences pref = context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(Constants.USER, new Gson().toJson(user));
        editor.putBoolean(KEY_IS_GUEST, false); // Not a guest when setting a user
        editor.apply();
    }

    public User getUser(Context context) {
        SharedPreferences pref = context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
        String userJson = pref.getString(Constants.USER, "");
        return userJson.isEmpty() ? null : new Gson().fromJson(userJson, User.class);
    }

    public void setGuestMode(Context context, boolean isGuest) {
        SharedPreferences pref = context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(KEY_IS_GUEST, isGuest);
        if (isGuest) {
            editor.remove(Constants.USER); // Clear user data for guest mode
        }
        editor.apply();
    }

    public boolean isGuest(Context context) {
        SharedPreferences pref = context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
        return pref.getBoolean(KEY_IS_GUEST, false);
    }

    public void clearSharedPref(@NonNull Context context) {
        SharedPreferences pref = context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }
}