package com.util;

import android.app.Activity;
import android.app.Application;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @title 自定义的activity堆栈
 * @author robinchen
 *
 */
public class MainApplication extends Application {
	
	private LinkedList<Activity> activityList = new LinkedList<>();
	
	public LinkedList<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(LinkedList<Activity> activityList) {
		this.activityList = activityList;
	}

	private static MainApplication instance;
	
	private MainApplication(){
		
	}
	
	// 单例模式中获取唯一的MainApplication实例
	public static MainApplication getInstance(){
		if(instance == null){
			instance = new MainApplication();
		}
		return instance;
	}
	
	/**
	 * 添加Activity到容器中   
	 * @param activity
	 */
	public void addActivity(Activity activity){   
		activityList.add(activity);   
	}  
	
	/**
	 * @title 关闭activity
	 * @param cla
	 */
	public void finishActivity(Class<?> cla) {
		for(Activity activity:activityList){
			if(activity!=null){
				try{
					if(activity.getClass().equals(cla)){
						activityList.remove(activity);
						activity.finish();
						LogUtils.w("finishActivity:"+activity);
						break;
					}
				}catch(Exception e){
					continue;
				}
			}
		}   
	}
	
	/**
	 * @title 移除容器中的单个activity
	 * @param cla
	 */
	public void removeActivity(Class<?> cla){
		for(Activity activity:activityList){   
			if(activity!=null){
				try{
					if(activity.getClass().equals(cla)){
						activityList.remove(activity);
						LogUtils.w("removeActivity:"+activity);
						break;
					}
				}catch(Exception e){
					continue;
				}
				
			}
		}   
	}
	/**
	 * @title 移除容器中的多个activity
	 * @param clas
	 */
	public void removeActivity(Class<?>[] clas){
		Iterator<Activity> iterator = activityList.iterator();
		while(iterator.hasNext()){
			Activity activity=iterator.next();
			for(int i = 0; i < clas.length; i++){
				try{
					if(activity.getClass().equals(clas[i])){
						iterator.remove();
						LogUtils.w("removeActivity:"+activity);
					}
				}catch(Exception e){
					continue;
				}
			}
		}
	}
	
	public Activity getActivity(Class<?> cla){
		for(Activity activity:activityList){   
			if(activity!=null){
				try{
					if(activity.getClass().equals(cla)){
						return activity;   
					}
				}catch(Exception e){
					continue;
				}
			}
		}
		return null;
	}
	/**
	 * 遍历所有Activity并finish   
	 */
	public void exit() {
		Iterator<Activity> iterator = activityList.iterator();
		while(iterator.hasNext()){
			Activity activity=iterator.next();
			if(null!=activity){
				try{
					iterator.remove();
					activity.finish();
					LogUtils.w("finishActivity:"+activity);
				}catch(Exception e){
					continue;
				}
			}
		}
		System.exit(0);   
	}  
	
	/**
	 * @title 遍历所有activity并关闭
	 */
	public void finishAllActivity(){
		Iterator<Activity> iterator = activityList.iterator();
		while(iterator.hasNext()){
			Activity activity=iterator.next();
			try{
				if(null!=activity){
					iterator.remove();
					activity.finish();
					LogUtils.w("finishActivity:"+activity);
				}
			}catch(Exception e){
				continue;
			}
		}
	}
}
