package com.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.util.LogUtils;

public class CActivity extends BaseActivity implements View.OnClickListener{
    private Button over,next;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        LogUtils.i("c---onCreate");
        init();
    }
    private void init(){
        over= (Button) findViewById(R.id.over);
        next= (Button) findViewById(R.id.next);
        over.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.over:
                CActivity.this.finish();
                break;
            case R.id.next:
                Intent intent=new Intent(this,OtherActivity.class);
                startActivity(intent);
                break;
        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        LogUtils.e("c---onDestroy");
    }

    @Override
    protected int getLayoutId(){
        return R.layout.activity_c;
    }
}
