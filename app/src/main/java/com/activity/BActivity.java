package com.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.util.LogUtils;

public class BActivity extends BaseActivity implements View.OnClickListener{
    private Button over,next,pdf;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        LogUtils.i("b---onCreate");
        init();
    }

    private void init(){
        over= (Button) findViewById(R.id.over);
        next= (Button) findViewById(R.id.next);
        pdf= (Button) findViewById(R.id.bt_pdf);
        pdf.setOnClickListener(this);
        over.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.over:
                BActivity.this.getParent().finish();
                break;
            case R.id.next:
                Context mContext = BActivity.this.getParent();
                final Dialog mDialog=new Dialog(mContext);
                View diaView=View.inflate(BActivity.this, R.layout.querydialog, null);
                Window win = mDialog.getWindow();
                WindowManager.LayoutParams params = new WindowManager.LayoutParams();
                params.gravity = Gravity.RIGHT;
                params.height = WindowManager.LayoutParams.FILL_PARENT;
                params.y = 20;//设置y坐标
                win.setAttributes(params);
                mDialog.setContentView(diaView);
                Button btback= (Button) diaView.findViewById(R.id.back);
                Button btnext= (Button) diaView.findViewById(R.id.bt_next);
                mDialog.show();
                btnext.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        new Handler().postDelayed(new Runnable(){
                            @Override
                            public void run(){
                                Intent intent=new Intent(BActivity.this,OtherActivity.class);
                                startActivity(intent);
                            }
                        },200);
                        mDialog.dismiss();
                    }
                });
                break;
            case R.id.bt_pdf:
                Intent intent=new Intent(BActivity.this,PDFActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onDestroy(){
        LogUtils.e("b---onDestroy----up");
        super.onDestroy();
        LogUtils.e("b---onDestroy----end");
    }

    @Override
    protected int getLayoutId(){
        return R.layout.activity_b;
    }
}
