package com.bisht.firebaseda;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Rishabh on 5/10/2017.
 */
public class firebaseda extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
