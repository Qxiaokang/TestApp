package com.example.admin.bolojie.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.bolojie.R;
import com.example.admin.bolojie.bean.Living;
import com.example.admin.bolojie.fragment.HotFragment;
import com.example.admin.bolojie.interfaces.MultiItemTypeSupport;
import com.example.admin.bolojie.util.ViewHolder;

import java.util.List;

/**
 * Created by Admin on 2017/12/22.
 */
public  class HotLivingAdapter<T> extends ComAdapter<T>{
    protected MultiItemTypeSupport<T> multiItemTypeSupport;
    private int type;
    private int livePosition=-1;
    private int position;
    public HotLivingAdapter(Context context, int mLayoutId, List<T> mDatas,MultiItemTypeSupport<T> multiItemTypeSupport){
        super(context, -1, mDatas);
        this.livePosition=mLayoutId;
        this.multiItemTypeSupport=multiItemTypeSupport;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        int layoutId=multiItemTypeSupport.getLayoutId(viewType);
        ViewHolder viewHolder=ViewHolder.get(mContext,parent,layoutId);
        return viewHolder;
    }

    @Override
    public void convert(ViewHolder holder, T t){
        Living living= (Living) t;
        if(type== HotFragment.TYPE_TOP){
            holder.setText(R.id.tv_name,living.getUser().getNickname());
            holder.setText(R.id.tv_num,living.getUsers()+"观众");
            holder.setText(R.id.tv_city,living.getUser().getCity());
            holder.setText(R.id.tv_familyname,living.getFamily().getName());
            holder.setImageByUrl(R.id.iv_circle,living.getUser().getAvatar());
            holder.setImageByUrl(R.id.iv_cover,living.getCover());
            holder.setImageByUrl(R.id.iv_circle_family,living.getFamily().getAvatar());
        }
        if(type==HotFragment.TYPE_BOT){
            TextView tvMore=holder.getTextViewById(R.id.tv_more);
            if(position==livePosition){
                tvMore.setVisibility(View.VISIBLE);
                holder.setText(R.id.tv_more,"更多热门");
            }else if(position==livePosition+1){
                tvMore.setVisibility(View.VISIBLE);
                holder.setText(R.id.tv_more,"");
            }else {
                tvMore.setVisibility(View.GONE);
            }
            holder.setImageByUrl(R.id.iv_item,living.getCover());
            holder.setText(R.id.tv_city,living.getUser().getCity());
            holder.setText(R.id.tv_name,living.getUser().getNickname());
            holder.setText(R.id.tv_family,living.getFamily().getName());
        }
    }

    @Override
    public int getItemViewType(int position){
        this.position=position;
        type=multiItemTypeSupport.getItemViewType(position,mDatas.get(position));
        return type;
    }
}
