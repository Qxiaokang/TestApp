package com.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.util.ComUtil;
import com.view.HeartLayout;

public class LiveActivity extends BaseActivity implements View.OnClickListener{
    private HeartLayout heartLayout;
    private Button btStart,btEnd;
    private ImageView ivHeart,ivGift;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        heartLayout= (HeartLayout) findViewById(R.id.ly_ht);
        btStart= (Button) findViewById(R.id.anmi_start);
        btEnd= (Button) findViewById(R.id.anmi_end);
        ivHeart= (ImageView) findViewById(R.id.iv_heart);
        ivGift= (ImageView) findViewById(R.id.iv_gift);
        ivGift.setOnClickListener(this);
        btEnd.setOnClickListener(this);
        btStart.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId(){
        return R.layout.activity_live;
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.ly_ht:
                heartLayout.addFavor();
                break;
            case R.id.anmi_start:
                ComUtil.startAnim(ivHeart);
                break;
            case R.id.anmi_end:
                ComUtil.stopAnim(ivHeart);
                break;
            case R.id.iv_gift:
                startObjectAnim(ivGift);
                break;
            default:
                break;
        }
    }
    private void startObjectAnim(View view){
        ObjectAnimator.ofFloat(view,"rotationY",0,360.0f).setDuration(2000).start();
    }
}
