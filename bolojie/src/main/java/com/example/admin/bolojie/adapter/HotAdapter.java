package com.example.admin.bolojie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.admin.bolojie.R;
import com.example.admin.bolojie.bean.Data;
import com.example.admin.bolojie.bean.Hot;
import com.example.admin.bolojie.bean.Living;
import com.example.admin.bolojie.view.CircleImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/12/13.
 */
public class HotAdapter extends RecyclerView.Adapter<HotAdapter.MHolder>{
    private Context context;
    private Data data;
    private int tag;
    private List<Living> livings=new ArrayList<>();
    public HotAdapter(){

    }
    public HotAdapter(Context context, Data data, int tag){
        this.context=context;
        this.data=data;
        this.tag=tag;
        if(tag==4){
            Hot hot= (Hot) data;
            List<Hot.ListBean> list = hot.getList();
            for(int i = 0; i < list.size(); i++){
                if(i==0){
                    livings=list.get(i).getLivelist();
                }
            }
        }
    }
    @Override
    public MHolder onCreateViewHolder(ViewGroup parent, int viewType){
        MHolder  mHoder=new MHolder(LayoutInflater.from(context).inflate(R.layout.hot_item,parent,false));
        return mHoder;
    }

    @Override
    public void onBindViewHolder(MHolder holder, int position){
        updateItem(holder,position);
    }

    @Override
    public int getItemCount(){
        return livings==null?0:livings.size();
    }
    class MHolder extends RecyclerView.ViewHolder{
        private CircleImageView ivUser,ivFamily;
        private ImageView ivCover;
        private TextView tv_name,tv_city,tv_family,tv_num;
        public MHolder(View itemView){
            super(itemView);
            ivCover= (ImageView) itemView.findViewById(R.id.iv_cover);
            ivUser= (CircleImageView) itemView.findViewById(R.id.iv_circle);
            ivFamily= (CircleImageView) itemView.findViewById(R.id.iv_circle_family);
            tv_name= (TextView) itemView.findViewById(R.id.tv_name);
            tv_family= (TextView) itemView.findViewById(R.id.tv_familyname);
            tv_num= (TextView) itemView.findViewById(R.id.tv_num);
            tv_city= (TextView) itemView.findViewById(R.id.tv_city);
        }
    }
    private void updateItem(MHolder mHoder,int position){
        if(tag==4){
            Living living = livings.get(position);
            Glide.with(context)
                    .load(living.getUser().getAvatar())
                    .crossFade()
                    .skipMemoryCache(true)
                    .fallback(R.drawable.pic_userimage_null)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mHoder.ivUser);
            mHoder.tv_name.setText(living.getUser().getNickname());
            mHoder.tv_num.setText(living.getUsers()+"观众");
            mHoder.tv_city.setText(living.getUser().getCity());
            mHoder.tv_family.setText(living.getFamily().getName());
            Glide.with(context)
                    .load(living.getCover())
                    .crossFade()
                    .skipMemoryCache(true)
                    .fallback(R.drawable.pic_userimage_null)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mHoder.ivCover);
            Glide.with(context)
                    .load(living.getFamily().getAvatar())
                    .crossFade()
                    .fallback(R.drawable.pic_userimage_null)
                    .skipMemoryCache(true)//跳过内存缓存
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mHoder.ivFamily);

        }
    }
}
