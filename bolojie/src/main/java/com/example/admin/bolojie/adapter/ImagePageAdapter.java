package com.example.admin.bolojie.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Admin on 2017/12/13.
 */
public class ImagePageAdapter extends PagerAdapter{
    private List<String> listUrl;
    private Context context;
    public ImagePageAdapter(){

    }
    public ImagePageAdapter(Context context,List<String> list){
        this.context=context;
        this.listUrl=list;
    }
    @Override
    public int getCount(){
        return listUrl==null?0:listUrl.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        ImageView imageView=new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(context)
                .load(listUrl.get(position))
                .skipMemoryCache(true)
                .into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        //super.destroyItem(container, position, object);
        //container.removeView((View) object);
    }
}
