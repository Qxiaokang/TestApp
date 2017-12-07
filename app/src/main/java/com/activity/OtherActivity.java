package com.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.util.LogUtils;
import com.util.MainApplication;

public class OtherActivity extends BaseActivity implements View.OnClickListener{
    private Button btFinish=null;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        LogUtils.i("other---onCreate");
        btFinish= (Button) findViewById(R.id.finish);
        btFinish.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        MainApplication.getInstance().finishAllActivity();
        Intent intent=new Intent(this,Localctivity.class);
        startActivity(intent);
        OtherActivity.this.finish();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        LogUtils.e("other---onDestroy");
    }

    @Override
    protected int getLayoutId(){
        return R.layout.activity_other;
    }
}
