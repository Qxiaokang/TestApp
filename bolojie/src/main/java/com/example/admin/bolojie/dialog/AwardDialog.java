package com.example.admin.bolojie.dialog;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.bolojie.R;

/**
 * Created by Admin on 2017/12/8.
 */
public class AwardDialog extends Dialog implements View.OnClickListener{
    private ObjectAnimator anim;
    private ImageView ivBg;
    private Button send;
    public AwardDialog(Context context){
        super(context);
        init();
    }

    private void init(){
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_award);
        setDialog();
    }

    public AwardDialog(Context context, int themeResId){
        super(context, themeResId);
        init();
    }
    public void setDialog(){
        this.setCancelable(false);
        ivBg= (ImageView) this.findViewById(R.id.iv_award_bag);
        send= (Button) findViewById(R.id.bt_send_gift);
        send.setOnClickListener(this);
        anim=ObjectAnimator.ofFloat(ivBg,"rotation",0,360);
        anim.setRepeatMode(ValueAnimator.INFINITE);
        anim.start();
    }

    @Override
    public void onClick(View view){
        this.dismiss();
    }
}
