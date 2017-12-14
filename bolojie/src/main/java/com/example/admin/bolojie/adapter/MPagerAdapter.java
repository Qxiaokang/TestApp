package com.example.admin.bolojie.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Admin on 2017/12/11.
 */
public class MPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragmentList;
    private List<String> titles;
    public MPagerAdapter(FragmentManager fm){
        super(fm);
    }
    public MPagerAdapter(FragmentManager fm,List<Fragment> fragments,List<String> titles){
        super(fm);
        this.fragmentList=fragments;
        this.titles=titles;
    }
    @Override
    public Fragment getItem(int position){
        return fragmentList.get(position);
    }

    @Override
    public int getCount(){
        return fragmentList==null?0:fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return titles.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        //super.destroyItem(container, position, object);
    }
}
