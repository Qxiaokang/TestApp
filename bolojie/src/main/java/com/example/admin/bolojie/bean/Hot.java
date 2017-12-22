package com.example.admin.bolojie.bean;

import java.util.List;

/**
 * Created by Admin on 2017/12/20.
 */
public class Hot extends Data{

    /**
     * ret : 0
     * msg :
     * bar : [{"id":246,"image":"http://yiqi1717-10009627.image.myqcloud.com/6936501e-d010-487a-bc1c-6aee1333eef7?imageView2/2/w/800/","parameters":"html|https://hd.yiqi17xiu.com/zxzd"},{},{},{},{},{},{}]
     * list : [{"id":19,"template":"NORMAL","numerical":"USERS","name":"热门","is_show_name":false,"parameters":"","line":1,"waterfall":false,"livelist":[]},{}]
     */

    private String ret;
    private String msg;
    private List<BarBean> bar;
    private List<ListBean> list;

    public String getRet(){
        return ret;
    }

    public void setRet(String ret){
        this.ret = ret;
    }

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }

    public List<BarBean> getBar(){
        return bar;
    }

    public void setBar(List<BarBean> bar){
        this.bar = bar;
    }

    public List<ListBean> getList(){
        return list;
    }

    public void setList(List<ListBean> list){
        this.list = list;
    }

    public static class BarBean{
        /**
         * id : 246
         * image : http://yiqi1717-10009627.image.myqcloud.com/6936501e-d010-487a-bc1c-6aee1333eef7?imageView2/2/w/800/
         * parameters : html|https://hd.yiqi17xiu.com/zxzd
         */

        private int id;
        private String image;
        private String parameters;

        public int getId(){
            return id;
        }

        public void setId(int id){
            this.id = id;
        }

        public String getImage(){
            return image;
        }

        public void setImage(String image){
            this.image = image;
        }

        public String getParameters(){
            return parameters;
        }

        public void setParameters(String parameters){
            this.parameters = parameters;
        }
    }

    public static class ListBean{
        /**
         * id : 19
         * template : NORMAL
         * numerical : USERS
         * name : 热门
         * is_show_name : false
         * parameters :
         * line : 1
         * waterfall : false
         * livelist : []
         */

        private int id;
        private String template;
        private String numerical;
        private String name;
        private boolean is_show_name;
        private String parameters;
        private int line;
        private boolean waterfall;
        private List<Living> livelist;

        public int getId(){
            return id;
        }

        public void setId(int id){
            this.id = id;
        }

        public String getTemplate(){
            return template;
        }

        public void setTemplate(String template){
            this.template = template;
        }

        public String getNumerical(){
            return numerical;
        }

        public void setNumerical(String numerical){
            this.numerical = numerical;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public boolean isIs_show_name(){
            return is_show_name;
        }

        public void setIs_show_name(boolean is_show_name){
            this.is_show_name = is_show_name;
        }

        public String getParameters(){
            return parameters;
        }

        public void setParameters(String parameters){
            this.parameters = parameters;
        }

        public int getLine(){
            return line;
        }

        public void setLine(int line){
            this.line = line;
        }

        public boolean isWaterfall(){
            return waterfall;
        }

        public void setWaterfall(boolean waterfall){
            this.waterfall = waterfall;
        }

        public List<Living> getLivelist(){
            return livelist;
        }

        public void setLivelist(List<Living> livelist){
            this.livelist = livelist;
        }
    }
}
