package com.example.admin.bolojie.acvitity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Window;

/**activity基类
 * @author Admin
* */
public abstract class  BaseActivity extends AppCompatActivity{
    //屏幕宽高
    protected int screenW,screenH;
    //密度
    protected float density;
    //dpi
    protected int dpi;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//去掉title
        setContentView(getContentViewId());
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenW=dm.widthPixels;
        screenH=dm.heightPixels;
        density=dm.density;
        dpi=dm.densityDpi;
    }
    abstract int getContentViewId();
}
