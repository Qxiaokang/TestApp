package com.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.adapter.ImageAdapter;
import com.bean.Image;
import com.util.InitContent;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ImageActivity extends BaseActivity implements ImageAdapter.IImage, ImageAdapter.IImageLongClick{
    private RecyclerView recyclerView;
    private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private List<Image> listImage=null;
    private ImageAdapter imageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initViews();
    }

    @Override
    protected int getLayoutId(){
        return R.layout.activity_image;
    }

    private void initViews(){
        listImage=new ArrayList<>();
        recyclerView= (RecyclerView) findViewById(R.id.rv_image);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,2);
        File file=new File(InitContent.getinStance().getPhotoPath());
        if(file.exists()&&file.isDirectory()){
            File[] files = file.listFiles();
            for(int i = 0; i < files.length; i++){
                if(files[i].getName().endsWith(".jpg")){
                    Image image=new Image();
                    image.setCreateDate(dateFormat.format(files[i].lastModified()));
                    image.setImageName(files[i].getName());
                    image.setImagePath(files[i].getAbsolutePath());
                    listImage.add(image);
                }
            }
        }
        imageAdapter=new ImageAdapter(this,listImage);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(imageAdapter);
        imageAdapter.setImageClicklistenner(this);
        imageAdapter.setImageLongClickListenner(this);
    }

    @Override
    public void setImageClick(View v, Image image){
        Intent intent=new Intent(this,FullImageActivity.class);
        intent.putExtra("path",image.getImagePath());
        startActivity(intent);
    }

    @Override
    public void setImageLongClick(View v, final Image image){
        new AlertDialog.Builder(ImageActivity.this,android.R.style.Theme_Dialog)
            .setTitle("提示")
            .setMessage("确认删除？")
            .setCancelable(false)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setPositiveButton("确定", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i){
                    deletePic(image);
                    dialogInterface.dismiss();
                }
            })
            .setNegativeButton("取消", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i){
                   dialogInterface.dismiss();
                }
            })
            .show()
        ;
    }
    private void deletePic(Image image){
        File file=new File(image.getImagePath());
        if(file.exists()){
            file.delete();
        }
        for(int i = 0; i < listImage.size(); i++){
            if(listImage.get(i).getImageName().endsWith(image.getImageName())){
                listImage.remove(i);
                break;
            }
        }
        imageAdapter.refresh(listImage);
    }
}
