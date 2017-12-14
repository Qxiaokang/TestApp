package com.example.admin.bolojie.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.admin.bolojie.R;

/**
 * Created by Admin on 2017/12/13.
 */
public class PageIndexView extends View{
    /**
     * 几个圆？
     */
    private int count = 4;

    /**
     * 圆点的半径
     */
    private float radius = 10;

    /**
     * 默认的颜色
     */
    private int defaultColor = Color.GRAY;

    /**
     * 选中的颜色
     */
    private int selectedColor = Color.RED;

    /**
     * 圆点的间距
     */
    private float circlePadding = 20;

    /**
     * 第一个圆点最左侧的座标
     */
    private float fromX, fromY;

    private Paint paint = new Paint();

    /**
     * 当前选中的索引
     */
    private int currIndex;

    public PageIndexView(Context context){
        super(context);

    }

    public PageIndexView(Context context, AttributeSet attrs){
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PageIndexView);
        count = typedArray.getInt(R.styleable.PageIndexView_view_count, 4);
        radius = typedArray.getFloat(R.styleable.PageIndexView_view_radius, 10);
        defaultColor = typedArray.getColor(R.styleable.PageIndexView_view_defaultColor, Color.GRAY);
        selectedColor = typedArray.getColor(R.styleable.PageIndexView_view_selectedColor, Color.RED);
        circlePadding = typedArray.getFloat(R.styleable.PageIndexView_view_circlePadding, 20);
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //计算起始点坐标
        fromX = (getWidth() - radius * 2 * count - circlePadding * (count - 1)) / 2;
        fromY = getHeight() / 2;
        //抗锯齿
        paint.setAntiAlias(true);
        //画圆点
        for(int i = 0; i < count; i++){
            if(i == currIndex){
                paint.setColor(selectedColor);
                paint.setStyle(Paint.Style.FILL);
            }else{
                paint.setColor(defaultColor);
                paint.setStyle(Paint.Style.STROKE);
            }
            canvas.drawCircle(fromX + radius + (radius * 2 + circlePadding) * i, fromY, radius, paint);
        }
    }

    public void setCurrIndex(int index){
        //改变当前选中的值
        currIndex = index;
        //重新绘制一次
        invalidate();
    }
    public void setCount(int count){
        this.count=count;
        invalidate();
    }
}
