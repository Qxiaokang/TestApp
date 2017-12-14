package com.example.admin.bolojie.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by Admin on 2017/12/12.
 */
public class MobileApplication extends Application{
    public static Context context;
    @Override
    public void onCreate(){
        super.onCreate();
        context=this.getApplicationContext();
    }
}
