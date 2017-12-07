package com.bean;

/**
 * Created by Admin on 2017/11/13.
 */
public class Image{
    private String imageName;
    private String createDate;
    private String imagePath;
    public String getCreateDate(){
        return createDate;
    }

    public void setCreateDate(String createDate){
        this.createDate = createDate;
    }

    public String getImageName(){
        return imageName;
    }

    public void setImageName(String imageName){
        this.imageName = imageName;
    }

    public String getImagePath(){
        return imagePath;
    }

    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }

}
