package com.example.admin.bolojie.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.admin.bolojie.R;

/**
 * Created by Admin on 2017/12/11.
 */
public class PublishWindow extends PopupWindow{
    private ImageView ivCancel,ivVideo,ivLiving;
    private Context context;
    private View.OnClickListener onClickListener;
    public PublishWindow(){

    }
    public PublishWindow(Context context, View.OnClickListener onClickListener){
        this.context=context;
        this.onClickListener=onClickListener;
        init(context);
    }

    private void init(Context context){
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_pop_publish, null);
        this.setOutsideTouchable(false);
        this.setContentView(inflate);
        this.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
        ivCancel= (ImageView) inflate.findViewById(R.id.iv_publish_cancle);
        ivVideo= (ImageView) inflate.findViewById(R.id.iv_video);
        ivLiving= (ImageView) inflate.findViewById(R.id.iv_living);
        ivCancel.setOnClickListener(onClickListener);
        ivVideo.setOnClickListener(onClickListener);
        ivLiving.setOnClickListener(onClickListener);
        ColorDrawable colorDrawable=new ColorDrawable(0xb0000000);
        this.setBackgroundDrawable(colorDrawable);
        this.setAnimationStyle(R.style.pop_animation);
    }
    public void showPublishWindow(View view){
        this.showAtLocation(view, Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
    }
}
