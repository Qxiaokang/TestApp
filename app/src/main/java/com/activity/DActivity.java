package com.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.util.ComUtil;
import com.util.LogUtils;
import com.view.LinePathView;

import java.io.File;

public class DActivity extends BaseActivity implements View.OnClickListener{
    private Button over,next,clean,save,read;
    private LinePathView lpView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        LogUtils.i("d---onCreate");
        init();
    }
    private void init(){
        over= (Button) findViewById(R.id.over);
        next= (Button) findViewById(R.id.next);
        clean= (Button) findViewById(R.id.clean);
        lpView= (LinePathView) findViewById(R.id.line_path);
        save= (Button) findViewById(R.id.save);
        read= (Button) findViewById(R.id.read);
        read.setOnClickListener(this);
        save.setOnClickListener(this);
        clean.setOnClickListener(this);
        over.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.over:
                DActivity.this.finish();
                break;
            case R.id.next:
                Intent intent=new Intent(this,OtherActivity.class);
                startActivity(intent);
                break;
            case R.id.clean:
                lpView.cleanCanvas();
                break;
            case R.id.save:
                boolean b=lpView.savaBitmap(Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+"images"+File.separator+new ComUtil().getUUID()+".jpg");
                if(b){
                    Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"保存失败",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.read:
                Intent intent1=new Intent(this,ImageActivity.class);
                startActivity(intent1);
                break;
            default:

                break;
        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        LogUtils.e("d---onDestroy");
    }

    @Override
    protected int getLayoutId(){
        return R.layout.activity_d;
    }
}
