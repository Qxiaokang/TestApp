package com.example.admin.bolojie.dialog;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.bolojie.R;

/**自定义背景透明的dialog
 * Created by Admin on 2017/12/8.
 */
public class MProgressDialog extends Dialog{
    private ObjectAnimator anim;
    private ImageView ivBg;
    private Button send;
    private int width,height;//dialog的宽高
    private Context context;
    public MProgressDialog(Context context){
        super(context);
        init();
    }

    private void init(){
        setDialog();
    }

    public MProgressDialog(Context context, int themeResId){
        super(context, themeResId);
        init();
    }
    public MProgressDialog(Context context, int themeResId, int width, int height){
        super(context, themeResId);
        this.context=context;
        this.width=width;
        this.height=height;
        init();
    }
    //设置dialog相关属性，以及动画效果
    public void setDialog(){
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_progress);
        if(width!=0&&height!=0){
            WindowManager.LayoutParams attributes = this.getWindow().getAttributes();
            attributes.height=height;
            attributes.width=width;
            this.getWindow().setAttributes(attributes);
        }
        this.setCancelable(false);
        ivBg= (ImageView) this.findViewById(R.id.iv_gress);
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(ivBg,"rotate",0,360);
        objectAnimator.setDuration(1500);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.start();
    }
}
