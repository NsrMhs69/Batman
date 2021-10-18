package com.project.batman;

import android.app.Application;
import android.content.Context;

public class Apps extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
