package com.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.util.LogUtils;
import com.util.MainApplication;

public abstract class BaseActivity extends AppCompatActivity{
    protected int y,h;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        ViewGroup viewGroup= (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
        View view = viewGroup.getChildAt(0);
        if(view!=null&& Build.VERSION.SDK_INT>=14){
            view.setFitsSystemWindows(true);
        }
        MainApplication.getInstance().addActivity(this);
        WindowManager wm=getWindowManager();
        y=wm.getDefaultDisplay().getWidth();
        h=wm.getDefaultDisplay().getHeight();
        LogUtils.d("base----onCreate");
    }

    @Override
    protected void onDestroy(){
        MainApplication.getInstance().removeActivity(this.getClass());
        LogUtils.e("base---onDestroy");
        super.onDestroy();
    }
    abstract protected  int getLayoutId();
}
