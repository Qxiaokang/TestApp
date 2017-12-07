package com.util;

import android.app.Application;
import android.graphics.Bitmap;

import com.activity.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Admin on 2017/11/6.
 */

public class MobileApplication extends Application{
    private  RefWatcher refWatcher;
    @Override
    public void onCreate(){
        super.onCreate();
        refWatcher = LeakCanary.install(this);
        initImageLoader();
    }
    //imageLoader配置
    private void initImageLoader(){
        ImageLoaderConfiguration configuration=ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);
    }
    public static DisplayImageOptions getOptions(){
        DisplayImageOptions options=new DisplayImageOptions.Builder()
                .bitmapConfig(Bitmap.Config.RGB_565)
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .showImageOnLoading(R.drawable.default_pic)
                .build();
        return options;
    }
}
