package com.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.util.LogUtils;
import com.util.MainApplication;

public class MainActivity extends TabActivity{
    private TabHost tabHost=null;
    private Intent intent=null;
    private TabHost.TabSpec tabSpec=null;
    private int tabId=1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtils.i("main---onCreate");
        MainApplication.getInstance().addActivity(this);
        initTabContent();

    }

    private void initTabContent(){
        tabHost=getTabHost();
        LinearLayout bflate = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.minitab, null);
        TextView Bview = (TextView) bflate.findViewById(R.id.tab_label);
        Bview.setText("B");

        LinearLayout cflate = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.minitab, null);
        TextView Cview = (TextView) cflate.findViewById(R.id.tab_label);
        Cview.setText("C");

        LinearLayout dflate = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.minitab, null);
        TextView Dview = (TextView) dflate.findViewById(R.id.tab_label);
        Dview.setText("D");
        intent=new Intent(this,BActivity.class);
        tabSpec=tabHost.newTabSpec("0");
        tabSpec.setIndicator(bflate).setContent(intent);
        tabHost.addTab(tabSpec);

        intent=new Intent(this,CActivity.class);
        tabSpec=tabHost.newTabSpec("1");
        tabSpec.setIndicator(cflate).setContent(intent);
        tabHost.addTab(tabSpec);

        intent=new Intent(this,DActivity.class);
        tabSpec=tabHost.newTabSpec("2");
        tabSpec.setIndicator(dflate).setContent(intent);
        tabHost.addTab(tabSpec);
        tabHost.setCurrentTab(tabId);
        ((TextView)tabHost.getTabWidget().getChildAt(tabId).findViewById(R.id.tab_label)).setBackgroundColor(Color.WHITE);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            @Override
            public void onTabChanged(String s){
                int tab=Integer.parseInt(s);
                LogUtils.i("tab:"+tab);
                int childCount = tabHost.getTabWidget().getChildCount();
                for(int i = 0; i < childCount; i++){
                    TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(R.id.tab_label);
                    tv.setBackgroundColor(Color.BLUE);
                }
                ((TextView)tabHost.getTabWidget().getChildAt(tab).findViewById(R.id.tab_label)).setBackgroundColor(Color.WHITE);
        }
        });
    }

    @Override
    protected void onDestroy(){
        LogUtils.w("----------------------------------------");
        super.onDestroy();
        MainApplication.getInstance().removeActivity(MainActivity.class);
        LogUtils.e("main---onDestroy");
    }
}
