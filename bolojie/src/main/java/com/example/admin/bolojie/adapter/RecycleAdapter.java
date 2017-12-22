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
import com.example.admin.bolojie.bean.NewMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/12/13.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MHoder>{
    private Context context;
    private Data data;
    private int tag;
    private List<String> listUrl=new ArrayList<String>();
    private List<String> listCity=new ArrayList<String>();
    private List<String> listName=new ArrayList<String>();
    private List<String> listHome=new ArrayList<String>();
    public RecycleAdapter(){

    }
    public RecycleAdapter(Context context, Data data,int tag){
        this.context=context;
        this.data=data;
        this.tag=tag;
        if(tag==1){
                listUrl.clear();
                listCity.clear();
                List<NewMessage.InfoBean.LivelistBean> livelist = ((NewMessage) data).getInfo().getLivelist();
                for(int i = 0; i < livelist.size(); i++){
                    listUrl.add(livelist.get(i).getCover());
                    listCity.add(livelist.get(i).getUser().getCity());
                }
        }
    }
    @Override
    public MHoder onCreateViewHolder(ViewGroup parent, int viewType){
        MHoder mHoder = new MHoder(LayoutInflater.from(context).inflate(R.layout.new_recycle_item,parent,false));
        return mHoder;
    }

    @Override
    public void onBindViewHolder(MHoder holder, int position){
        updateItem(holder,position);
    }

    @Override
    public int getItemCount(){
        return listUrl==null?0:listUrl.size();
    }

    class MHoder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;

        public MHoder(View itemView){
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_item);
            textView = (TextView) itemView.findViewById(R.id.tv_city);
        }
    }
    private void updateItem(MHoder mHoder,int position){
        if(tag==1){
            mHoder.imageView.setAdjustViewBounds(true);
            Glide.with(context)
                    .load(listUrl.get(position))
                    .crossFade()
                    .fallback(R.drawable.pic_userimage_null)
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mHoder.imageView);
            mHoder.textView.setText(listCity.get(position));
        }
    }
}
