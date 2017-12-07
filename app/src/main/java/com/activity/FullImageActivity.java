package com.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class FullImageActivity extends BaseActivity{
    private String path;
    private ImageView imageView;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        Intent intent=getIntent();
        path=intent.getStringExtra("path");
        imageView= (ImageView) findViewById(R.id.iv_full);
        bitmap= BitmapFactory.decodeFile(path);
        imageView.setImageBitmap(bitmap);
    }

    @Override
    protected void onDestroy(){
        if(bitmap!=null){
            bitmap.recycle();
            bitmap=null;
        }
        super.onDestroy();
    }

    @Override
    protected int getLayoutId(){
        return R.layout.activity_full_image;
    }
}
