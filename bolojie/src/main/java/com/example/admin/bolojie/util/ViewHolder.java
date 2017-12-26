package com.example.admin.bolojie.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.admin.bolojie.R;

/**
 * Created by Admin on 2017/12/22.
 */
public class ViewHolder extends RecyclerView.ViewHolder{
    private Context mContext;
    private View mContentView;
    private SparseArray<View> mViews;
    public ViewHolder(Context context, View itemView, ViewGroup viewGroup){
        super(itemView);
        mContext=context;
        mContentView=itemView;
        mViews=new SparseArray<View>();
    }
    public static ViewHolder get(Context context, ViewGroup parent, int layoutId)
    {

        View itemView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        ViewHolder holder = new ViewHolder(context, itemView, parent);
        return holder;
    }


    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId)
    {
        View view = mViews.get(viewId);
        if (view == null)
        {
            view = mContentView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }
    public ViewHolder setText(int tvId,String text){
        TextView textView=getView(tvId);
        textView.setText(text==null?"":text);
        return this;
    }
    public TextView getTextViewById(int id){
        return getView(id);
    }
    public ViewHolder setImageByRes(int ivId,int res){
        ImageView imageView=getView(ivId);
        imageView.setImageResource(res);
        return this;
    }
    public ViewHolder setImageByUrl(int ivId,String imgUrl){
        ImageView imageView=getView(ivId);
        Glide.with(mContext)
                .load(imgUrl)
                .crossFade()
                .skipMemoryCache(true)
                .fallback(R.drawable.pic_userimage_null)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
        return this;
    }
}
