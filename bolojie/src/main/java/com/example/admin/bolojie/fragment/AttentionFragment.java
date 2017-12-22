package com.example.admin.bolojie.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.bolojie.R;
import com.example.admin.bolojie.adapter.AttentionAdapter;
import com.example.admin.bolojie.bean.Attention;
import com.example.admin.bolojie.bean.Data;

import java.util.List;

/**

 */
public class AttentionFragment extends Fragment{
    private RecyclerView recyclerView;
    private TextView title;
    public AttentionFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_attention,null);
        recyclerView= (RecyclerView) view.findViewById(R.id.att_recycle);
        title= (TextView) view.findViewById(R.id.tv_title);
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
    }
    public void updateFragment(int tag, Data data){
        Attention attention= (Attention) data;
        List<Attention.ListBean> list = attention.getList();
        for(int i = 0; i < list.size(); i++){
            if(i==1){
                title.setText(list.get(i).getName());
            }
        }
        initRecycle(getContext(),tag,data);
    }
    private void initRecycle(Context context, int tag, Data data){
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        gridLayoutManager.setAutoMeasureEnabled(true);
        AttentionAdapter recycleAdapter=new AttentionAdapter(context,data,tag);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recycleAdapter);
    }
}
