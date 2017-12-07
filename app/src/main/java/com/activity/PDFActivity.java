package com.activity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnDrawListener;
import com.joanzapata.pdfview.listener.OnLoadCompleteListener;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

import java.io.File;

public class PDFActivity extends BaseActivity implements View.OnClickListener, OnPageChangeListener, OnLoadCompleteListener, OnDrawListener{
    private Button btnOpen;
    private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    protected int getLayoutId(){
        return R.layout.activity_pdf;
    }

    private void init(){
        btnOpen= (Button) findViewById(R.id.bt_open);
        pdfView= (PDFView) findViewById(R.id.pv_content);
        btnOpen.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
       displayFromAssets("kotlin-docs.pdf");
    }
    private void displayFromAssets(String assetFileName ) {
        pdfView.fromAsset(assetFileName)   //设置pdf文件地址
                .defaultPage(1)         //设置默认显示第1页
                .onPageChange(this)     //设置翻页监听
                .onLoad(this)           //设置加载监听
                .onDraw(this)            //绘图监听
                .showMinimap(false)     //pdf放大的时候，是否在屏幕的右上角生成小地图
                .swipeVertical( false )  //pdf文档翻页是否是垂直翻页，默认是左右滑动翻页
                .enableSwipe(true)   //是否允许翻页，默认是允许翻页
                //                 .pages()  //把 5 过滤掉
                .load();
    }

    @Override
    public void onPageChanged(int page, int pageCount){
        Toast.makeText(getApplicationContext(),page+"/"+pageCount,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadComplete(int nbPages){

    }

    @Override
    public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage){
    }

    private void displayFromFile( File file ) {
        pdfView.fromFile(file)   //设置pdf文件地址
                .defaultPage(6)         //设置默认显示第1页
                .onPageChange(this)     //设置翻页监听
                .onLoad(this)           //设置加载监听
                .onDraw(this)            //绘图监听
                .showMinimap(false)     //pdf放大的时候，是否在屏幕的右上角生成小地图
                .swipeVertical( false )  //pdf文档翻页是否是垂直翻页，默认是左右滑动翻页
                .enableSwipe(true)   //是否允许翻页，默认是允许翻
                // .pages( 2 ，5  )  //把2  5 过滤掉
                .load();
    }
}
