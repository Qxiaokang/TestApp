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
import com.example.admin.bolojie.bean.Attention;
import com.example.admin.bolojie.bean.Data;
import com.example.admin.bolojie.bean.Living;
import com.example.admin.bolojie.bean.Recommend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/12/13.
 */
public class AttentionAdapter extends RecyclerView.Adapter<AttentionAdapter.AttentionHolder>{
    private Context context;
    private Data data;
    private int tag;
    private List<Living> livings=new ArrayList<Living>();
    public AttentionAdapter(){

    }
    public AttentionAdapter(Context context, Data data, int tag){
        this.context=context;
        this.data=data;
        this.tag=tag;
        if(tag==2){
                Attention  attention= (Attention) data;
                livings.clear();
                livings.addAll(attention.getInfo().getLivelist());
        }
        if(tag==3){
            Recommend recommend= (Recommend) data;
            List<Recommend.ListBean> list = recommend.getList();
            livings.clear();
            for(int i = 0; i < list.size(); i++){
                Recommend.ListBean listBean = list.get(i);
                List<Living> livelist = listBean.getLivelist();
                livings.addAll(livelist);
            }
        }
        /*if(tag==4){
            Hot hot= (Hot) data;
            List<Hot.ListBean> list = hot.getList();
            livings.clear();
            for(int i = 0; i < list.size(); i++){
                if(i<1){
                    break;
                }
                if(i==list.size()-1){
                    livings.addAll(list.get(i).getLivelist());
                }
            }
        }*/
    }
    @Override
    public AttentionHolder onCreateViewHolder(ViewGroup parent, int viewType){
        AttentionHolder  mHoder=new AttentionHolder(LayoutInflater.from(context).inflate(R.layout.att_item,parent,false));
        return mHoder;
    }

    @Override
    public void onBindViewHolder(AttentionHolder holder, int position){
        updateItem(holder,position);
    }

    @Override
    public int getItemCount(){
        return livings==null?0:livings.size();
    }
    class AttentionHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView tv_name,tv_city,tv_family;
        public AttentionHolder(View itemView){
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.iv_item);
            tv_name= (TextView) itemView.findViewById(R.id.tv_name);
            tv_city= (TextView) itemView.findViewById(R.id.tv_city);
            tv_family= (TextView) itemView.findViewById(R.id.tv_family);
        }
    }
    private void updateItem(AttentionHolder mHoder,int position){
        if(tag!=0){
            Living living = livings.get(position);
            mHoder.imageView.setAdjustViewBounds(true);
            Glide.with(context)
                    .load(living.getCover())
                    .crossFade()
                    .fallback(R.drawable.pic_userimage_null)
                    .skipMemoryCache(true)//跳过内存缓存
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mHoder.imageView);
            mHoder.tv_city.setText(living.getUser().getCity());
            mHoder.tv_name.setText(living.getUser().getNickname());
            mHoder.tv_family.setText(living.getFamily().getName());
        }
    }
}
