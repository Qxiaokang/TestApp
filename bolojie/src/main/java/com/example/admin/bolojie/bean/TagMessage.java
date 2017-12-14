package com.example.admin.bolojie.bean;

import java.util.List;

/**
 * Created by Admin on 2017/12/12.
 */
public class TagMessage extends Data{

    /**
     * ret : 0
     * msg :
     * list : [{"id":9,"name":"最新","multi":false,"mix":false,"is_index":false,"type":0,"menu":[]},{"id":11,"name":"关注","multi":false,"mix":true,"is_index":false,"type":0,"menu":[]},{"id":24,"name":"推荐","multi":true,"mix":false,"is_index":false,"type":0,"menu":[]},{"id":8,"name":"热门","multi":true,"mix":false,"is_index":true,"type":0,"menu":[]},{"id":10,"name":"附近","multi":false,"mix":false,"is_index":false,"type":0,"menu":[{"id":1,"optionlist":[{"is_select":false,"name":"看热门","value":"kan re men "},{"is_select":false,"name":"江浙沪皖","value":"jiang zhe hu wan"},{"is_select":true,"name":"珠三角","value":"zhu san jiao"},{"is_select":false,"name":"北方","value":"bei fang"},{"is_select":false,"name":"西南","value":"xi nan"},{"is_select":false,"name":"西北","value":"xi bei"}]},{"id":2,"optionlist":[{"is_select":false,"name":"离我最近","value":"li wo zui jin"}]}]},{"id":13,"name":"小视频","multi":false,"mix":false,"is_index":false,"type":2,"menu":[]},{"id":14,"name":"家族","multi":false,"mix":false,"is_index":false,"type":1,"menu":[]}]
     */

    private String ret;
    private String msg;
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

    public List<ListBean> getList(){
        return list;
    }

    public void setList(List<ListBean> list){
        this.list = list;
    }

    public static class ListBean{
        /**
         * id : 9
         * name : 最新
         * multi : false
         * mix : false
         * is_index : false
         * type : 0
         * menu : []
         */

        private int id;
        private String name;
        private boolean multi;
        private boolean mix;
        private boolean is_index;
        private int type;
        private List<?> menu;

        public int getId(){
            return id;
        }

        public void setId(int id){
            this.id = id;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public boolean isMulti(){
            return multi;
        }

        public void setMulti(boolean multi){
            this.multi = multi;
        }

        public boolean isMix(){
            return mix;
        }

        public void setMix(boolean mix){
            this.mix = mix;
        }

        public boolean isIs_index(){
            return is_index;
        }

        public void setIs_index(boolean is_index){
            this.is_index = is_index;
        }

        public int getType(){
            return type;
        }

        public void setType(int type){
            this.type = type;
        }

        public List<?> getMenu(){
            return menu;
        }

        public void setMenu(List<?> menu){
            this.menu = menu;
        }
    }

    @Override
    public String toString(){
        return "TagMessage{" +
                "ret='" + ret + '\'' +
                ", msg='" + msg + '\'' +
                ", list=" + list +
                '}';
    }
}
