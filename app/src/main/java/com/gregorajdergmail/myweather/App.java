package com.gregorajdergmail.myweather;

import android.app.Application;
import android.content.Context;

import com.gregorajdergmail.myweather.di.AppComponent;
import com.gregorajdergmail.myweather.di.DaggerAppComponent;
import com.gregorajdergmail.myweather.util.Log;


public class App extends Application {

    private static Context context;
    private static AppComponent appComponent;

    public static Context getContext() {
        return context;
    }

    public static AppComponent getComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d();
        context = getApplicationContext();

        appComponent = DaggerAppComponent.
//                create();
                builder().build();

        
    }



}
