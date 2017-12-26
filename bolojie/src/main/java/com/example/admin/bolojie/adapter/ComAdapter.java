package com.example.admin.bolojie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.admin.bolojie.util.ViewHolder;

import java.util.List;

/**
 * Created by Admin on 2017/12/22.
 */
public abstract class ComAdapter<T> extends RecyclerView.Adapter<ViewHolder>{
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    public ComAdapter(Context context,int mLayoutId,List<T> mDatas){
        this.mContext=context;
        mInflater=LayoutInflater.from(context);
        this.mLayoutId=mLayoutId;
        this.mDatas=mDatas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        ViewHolder viewHolder=ViewHolder.get(mContext,parent,mLayoutId);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        convert(holder, mDatas.get(position));
    }
    @Override
    public int getItemCount(){
        return mDatas.size();
    }
    public abstract void convert(ViewHolder holder, T t);
}
