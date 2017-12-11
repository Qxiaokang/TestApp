package com.example.admin.bolojie.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.RadioButton;

/**
 * Created by Admin on 2017/12/11.
 */
public class ComButton extends RadioButton{
    public ComButton(Context context){
        super(context);
    }

    public ComButton(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public ComButton(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawableBottom=compoundDrawables[3];
        if(drawableBottom!=null){
            int gravity=getGravity();
            int compoundDrawablePadding = getCompoundDrawablePadding();
            int intrinsicHeight = drawableBottom.getIntrinsicHeight();
            int intrinsicWidth = drawableBottom.getIntrinsicWidth();
            float bodyHeight=intrinsicHeight+compoundDrawablePadding;
            canvas.translate(0,0-(getHeight()-bodyHeight)/2);
            int left=0,top=0,right=0,bottom=0;
            if(gravity== Gravity.CENTER){
                left=(getWidth()-intrinsicHeight)/2;
                top= (int) ((getHeight()-bodyHeight)/2);
                right=left+intrinsicWidth;
                bottom=top+intrinsicHeight;
                drawableBottom.setBounds(left,top,right,bottom);
            }
        }
        super.onDraw(canvas);
    }
    private int getTestHeight(String text){
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) (fontMetrics.descent+fontMetrics.ascent+fontMetrics.leading);
    }
}
