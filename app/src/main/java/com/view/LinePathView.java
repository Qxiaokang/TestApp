package com.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.util.LogUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Admin on 2017/11/13.
 */
public class LinePathView extends View{
    private Context mContext;
    //Paint
    private Paint mPaint=new Paint();
    //Path
    private Path mPath=new Path();
    //
    private int mColor= Color.RED;
    //
    private int mBackColor=Color.GRAY;
    //start X Y
    private float mX,mY;
    //
    private int lineW=5;
    //
    private Canvas mCanvas;
    //
    private Bitmap mBitmap;
    //
    boolean isClean=false;

    public LinePathView(Context context){
        super(context);
        init(context);
    }
    public LinePathView(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context);
    }

    public LinePathView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        this.mContext=context;
        mPaint.setColor(mColor);
        mPaint.setStrokeWidth(lineW);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap,0,0,mPaint);
        canvas.drawPath(mPath,mPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w, h, oldw, oldh);
        mBitmap=Bitmap.createBitmap(getWidth(),getHeight(), Bitmap.Config.ARGB_8888);
        mCanvas=new Canvas(mBitmap);
        mCanvas.drawColor(mBackColor);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                tochDown(event);
                break;
            case MotionEvent.ACTION_MOVE:
                tochMove(event);
                break;
            case MotionEvent.ACTION_UP:
                tochUp(event);
                break;
        }
        invalidate();
        return true;
    }

    private void tochUp(MotionEvent event){
        mCanvas.drawPath(mPath,mPaint);
        mPath.reset();
    }

    private void tochMove(MotionEvent event){
        float moveX = event.getX();
        float moveY = event.getY();
        float x = Math.abs(moveX-mX);
        float y = Math.abs(moveY-mY);
        if(x>3||y>3){
            float cx = (moveX + mX) / 2;
            float cy = (moveY + mY) / 2;
            mPath.quadTo(mX,mY,cx,cy);
            mX=moveX;
            mY=moveY;
        }
    }

    private void tochDown(MotionEvent event){
        float downX = event.getX();
        float downY = event.getY();
        mX=downX;
        mY=downY;
        mPath.reset();
        mPath.moveTo(downX,downY);
    }
    public void cleanCanvas(){
        LogUtils.e("---clean---canvas");
        mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        invalidate();
    }

    public boolean savaBitmap(String path){
        boolean b=false;
        try{
            if(mBitmap!=null){
                LogUtils.d("---save---bitmap");
                Bitmap bitmap=mBitmap;
                ByteArrayOutputStream btOut=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,btOut);
                File file=new File(path);
                if(!file.exists()){
                     file.createNewFile();
                }
                FileOutputStream f=new FileOutputStream(file);
                f.write(btOut.toByteArray());
                btOut.close();
                f.close();
                btOut=null;
                f=null;
                b=true;
            }
        }catch(Exception e){
            LogUtils.e("catch:"+e.toString());
            b=false;
        }
        return b;
    }
    /**获取画板上的bitmap
    * */
    public Bitmap getBitmap(){
        setDrawingCacheEnabled(true);
        buildDrawingCache();
        Bitmap bp = getDrawingCache();
        setDrawingCacheEnabled(false);
        return bp;
    }
    /**
     * 逐行扫描 清除边界空白。
     *
     * @param bp
     * @param blank 边距留多少个像素
     * @return
     */
    private Bitmap clearBlank(Bitmap bp, int blank) {
        int HEIGHT = bp.getHeight();
        int WIDTH = bp.getWidth();
        int top = 0, left = 0, right = 0, bottom = 0;
        int[] pixs = new int[WIDTH];
        boolean isStop;
        //扫描上边距不等于背景颜色的第一个点
        for (int y = 0; y < HEIGHT; y++) {
            bp.getPixels(pixs, 0, WIDTH, 0, y, WIDTH, 1);
            isStop = false;
            for (int pix : pixs) {
                if (pix != mBackColor) {
                    top = y;
                    isStop = true;
                    break;
                }
            }
            if (isStop) {
                break;
            }
        }
        //扫描下边距不等于背景颜色的第一个点
        for (int y = HEIGHT - 1; y >= 0; y--) {
            bp.getPixels(pixs, 0, WIDTH, 0, y, WIDTH, 1);
            isStop = false;
            for (int pix : pixs) {
                if (pix != mBackColor) {
                    bottom = y;
                    isStop = true;
                    break;
                }
            }
            if (isStop) {
                break;
            }
        }
        pixs = new int[HEIGHT];
        //扫描左边距不等于背景颜色的第一个点
        for (int x = 0; x < WIDTH; x++) {
            bp.getPixels(pixs, 0, 1, x, 0, 1, HEIGHT);
            isStop = false;
            for (int pix : pixs) {
                if (pix != mBackColor) {
                    left = x;
                    isStop = true;
                    break;
                }
            }
            if (isStop) {
                break;
            }
        }
        //扫描右边距不等于背景颜色的第一个点
        for (int x = WIDTH - 1; x > 0; x--) {
            bp.getPixels(pixs, 0, 1, x, 0, 1, HEIGHT);
            isStop = false;
            for (int pix : pixs) {
                if (pix != mBackColor) {
                    right = x;
                    isStop = true;
                    break;
                }
            }
            if (isStop) {
                break;
            }
        }
        if (blank < 0) {
            blank = 0;
        }
        //计算加上保留空白距离之后的图像大小
        left = left - blank > 0 ? left - blank : 0;
        top = top - blank > 0 ? top - blank : 0;
        right = right + blank > WIDTH - 1 ? WIDTH - 1 : right + blank;
        bottom = bottom + blank > HEIGHT - 1 ? HEIGHT - 1 : bottom + blank;
        return Bitmap.createBitmap(bp, left, top, right - left, bottom - top);
    }
}
