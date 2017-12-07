package com.test;

import com.util.DataUtils;

import java.io.UnsupportedEncodingException;

/**
 * Created by Admin on 2017/12/6.
 */

public class Test{
    static  String string="surfaceView(layoutParams)去 除 不 符 合的 字符?&^T%#^T·.";
    static  String string1="鍘� 5435闄� ·涓� ·绗� 鍚堢殑 瀛楃?&^T%#^T路.·6431";
    private static final String  regex="^([\\u4e00-\\u9fa5]|[a-zA-Z0-9]|[·.\\-_@\\s])*$";
    public static void main(String args[]){
        try{
            string=new String(string.getBytes(),"gbk");
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        DataUtils.matchRegex(string1,regex);
    }
}
