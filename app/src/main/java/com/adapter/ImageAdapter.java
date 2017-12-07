package com.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.activity.R;
import com.bean.Image;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.util.MobileApplication;

import java.io.File;
import java.util.List;

/**
 * Created by Admin on 2017/11/13.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHoler> implements View.OnClickListener, View.OnLongClickListener{
    private Context context;
    private List<Image> images;
    private IImage iImage;
    private IImageLongClick iImageLongClick;
    public ImageAdapter(Context context, List<Image> images){
        this.context=context;
        this.images=images;
    }
    @Override
    public ImageHoler onCreateViewHolder(ViewGroup parent, int viewType){
        ImageHoler imageHoler=new ImageHoler(LayoutInflater.from(context).inflate(R.layout.image_item,parent,false));
        return imageHoler;
    }

    @Override
    public void onBindViewHolder(ImageHoler holder, int position){
        ImageView imageView = holder.imageView;
        TextView textView = holder.textView;
        ImageLoader.getInstance().displayImage(String.valueOf(Uri.fromFile(new File(images.get(position).getImagePath()))),imageView, MobileApplication.getOptions());
        textView.setText(images.get(position).getCreateDate());
        imageView.setOnClickListener(this);
        imageView.setOnLongClickListener(this);
        imageView.setTag(R.id.tag_iv,images.get(position));
    }
    @Override
    public int getItemCount(){
        return images==null?0:images.size();
    }

    @Override
    public void onClick(View view){
        iImage.setImageClick(view, (Image) view.getTag(R.id.tag_iv));
    }

    @Override
    public boolean onLongClick(View view){
        iImageLongClick.setImageLongClick(view, (Image) view.getTag(R.id.tag_iv));
        return true;
    }

    class ImageHoler extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public ImageHoler(View itemView){
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.iv_signature);
            textView= (TextView) itemView.findViewById(R.id.tv_time);
        }
    }
    public interface IImage{
        void setImageClick(View v,Image image);
    }
    public void setImageClicklistenner(IImage iImage){
        this.iImage=iImage;
    }
    public interface IImageLongClick{
        void setImageLongClick(View v,Image image);
    }
    public void setImageLongClickListenner(IImageLongClick iImageLongClick){
        this.iImageLongClick=iImageLongClick;
    }
    public void refresh(List<Image> list){
        this.images=list;
        notifyDataSetChanged();
    }
}
