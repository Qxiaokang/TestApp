package com.example.admin.bolojie.bean;

import java.util.List;

/**
 * Created by Admin on 2017/12/19.
 */
public class Living{

    /**
     * uid : 8680435
     * title : 我发起了一个直播，快来看看吧！
     * cover : http://yiqi1717-10009627.image.myqcloud.com/e002da06-dea8-4317-99a4-fab10735a383?imageView2/1/w/828/h/828
     * users : 1811
     * is_live : true
     * begin_live : 2017-12-14 10:45:05
     * netease_tid : 19145047
     * max_manager : 0
     * heats : 2400
     * heats2 : 0
     * displayorder : 3
     * home_displayorder : 1
     * new_displayorder : 0
     * family_displayorder : 999999
     * distance : 457km
     * display_heats : true
     * html_share : http://www.biubiuzhibo.com/share/live?live_uid=8680435
     * rtmp : http://yiqihdl.8686c.com/pajia/8680435.flv
     * rtmp_type : chinanetcenter
     * rtmp_id : 8680435
     * chat_id : 8680435151324830580
     * all_count : 55
     * praise_theme : 1
     * praise_countdown : 5
     * is_link_mic : false
     * user : {"uid":8680435,"uidx":8680435,"parent_uid":8985396,"avatar":"http://yiqi1717-10009627.image.myqcloud.com/e002da06-dea8-4317-99a4-fab10735a383?imageView2/1/w/260/h/260","nickname":"玫瑰🌹小晟涵ԅ","gender":2,"age":99,"role_id":2,"credits":327579,"live_credits":0,"live_credits_1":0,"live_adds":23,"live_shares":2,"live_magic":0,"province":"浙江省","city":"杭州市","sign":"吃好喝好长生不老🦁","excellent":false,"lastver":"20171115","ico":{"vip":true,"heat":false,"follow":false,"official":false,"sale":false,"beautiful":false,"newreg":false},"grade":{"lv":18,"id":4,"grade":"冠","exp":135702,"next":149539,"upgrade":13837,"color":"","image":"","vip_image":"http://yiqi1717-10009627.image.myqcloud.com/584b8761-2b8e-4d76-9f8b-62eff016df2e","medal_id":1,"medal_image":"http://yiqi1717-10009627.image.myqcloud.com/70970c43-7d9f-4175-ba62-18e308d9f7f6"},"grade2":{"lv":18,"id":4,"grade":"冠","exp":135702,"next":149539,"upgrade":13837,"color":"","image":"","vip_image":"http://yiqi1717-10009627.image.myqcloud.com/584b8761-2b8e-4d76-9f8b-62eff016df2e","medal_id":1,"medal_image":"http://yiqi1717-10009627.image.myqcloud.com/70970c43-7d9f-4175-ba62-18e308d9f7f6"},"certification":{"uid":0,"name":"","describe":"","status":0},"guardian":{"uid":0,"avatar":"http://yiqi1717-10009627.image.myqcloud.com/e8420c4b-6e32-4149-aa47-59e1a0021749","nickname":null}}
     * ad : {"title":"","avatar":"","cover":"","parameters":""}
     * family : {"uid":8985396,"name":"玫瑰🌹家族","slogan":"玫瑰🌹","notice":"大量招聘主播，有意向加V联系：79480908","avatar":"http://yiqi1717-10009627.image.myqcloud.com/db661d50-f3c8-46c9-a02f-e9189ec02b1c","displayorder_trend":37,"template":"","livelist":[]}
     * link_mic : {"beauty":true,"link_mic_disturb":false,"live_info":{"uid":0,"pushUrl":"http://yiqipzbpush.biubiuzhibo.com:7788/publish/trans/pajia","linkUrl":"pzsp://yiqipzbpush.biubiuzhibo.com:7788/live/ld/trans/pajia","encUrl":"pzsp://yiqipzbflv.biubiuzhibo.com:8000/live/ld/trans/pajia","slot":0,"room_id":0,"push_ndselect":3,"pull_ndselect":1},"user_list":[]}
     */

    private int uid;
    private String title;
    private String cover;
    private int users;
    private boolean is_live;
    private String begin_live;
    private String netease_tid;
    private int max_manager;
    private int heats;
    private int heats2;
    private int displayorder;
    private int home_displayorder;
    private int new_displayorder;
    private int family_displayorder;
    private String distance;
    private boolean display_heats;
    private String html_share;
    private String rtmp;
    private String rtmp_type;
    private String rtmp_id;
    private String chat_id;
    private int all_count;
    private int praise_theme;
    private int praise_countdown;
    private boolean is_link_mic;
    private UserBean user;
    private AdBean ad;
    private FamilyBean family;
    private LinkMicBean link_mic;

    public int getUid(){
        return uid;
    }

    public void setUid(int uid){
        this.uid = uid;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getCover(){
        return cover;
    }

    public void setCover(String cover){
        this.cover = cover;
    }

    public int getUsers(){
        return users;
    }

    public void setUsers(int users){
        this.users = users;
    }

    public boolean isIs_live(){
        return is_live;
    }

    public void setIs_live(boolean is_live){
        this.is_live = is_live;
    }

    public String getBegin_live(){
        return begin_live;
    }

    public void setBegin_live(String begin_live){
        this.begin_live = begin_live;
    }

    public String getNetease_tid(){
        return netease_tid;
    }

    public void setNetease_tid(String netease_tid){
        this.netease_tid = netease_tid;
    }

    public int getMax_manager(){
        return max_manager;
    }

    public void setMax_manager(int max_manager){
        this.max_manager = max_manager;
    }

    public int getHeats(){
        return heats;
    }

    public void setHeats(int heats){
        this.heats = heats;
    }

    public int getHeats2(){
        return heats2;
    }

    public void setHeats2(int heats2){
        this.heats2 = heats2;
    }

    public int getDisplayorder(){
        return displayorder;
    }

    public void setDisplayorder(int displayorder){
        this.displayorder = displayorder;
    }

    public int getHome_displayorder(){
        return home_displayorder;
    }

    public void setHome_displayorder(int home_displayorder){
        this.home_displayorder = home_displayorder;
    }

    public int getNew_displayorder(){
        return new_displayorder;
    }

    public void setNew_displayorder(int new_displayorder){
        this.new_displayorder = new_displayorder;
    }

    public int getFamily_displayorder(){
        return family_displayorder;
    }

    public void setFamily_displayorder(int family_displayorder){
        this.family_displayorder = family_displayorder;
    }

    public String getDistance(){
        return distance;
    }

    public void setDistance(String distance){
        this.distance = distance;
    }

    public boolean isDisplay_heats(){
        return display_heats;
    }

    public void setDisplay_heats(boolean display_heats){
        this.display_heats = display_heats;
    }

    public String getHtml_share(){
        return html_share;
    }

    public void setHtml_share(String html_share){
        this.html_share = html_share;
    }

    public String getRtmp(){
        return rtmp;
    }

    public void setRtmp(String rtmp){
        this.rtmp = rtmp;
    }

    public String getRtmp_type(){
        return rtmp_type;
    }

    public void setRtmp_type(String rtmp_type){
        this.rtmp_type = rtmp_type;
    }

    public String getRtmp_id(){
        return rtmp_id;
    }

    public void setRtmp_id(String rtmp_id){
        this.rtmp_id = rtmp_id;
    }

    public String getChat_id(){
        return chat_id;
    }

    public void setChat_id(String chat_id){
        this.chat_id = chat_id;
    }

    public int getAll_count(){
        return all_count;
    }

    public void setAll_count(int all_count){
        this.all_count = all_count;
    }

    public int getPraise_theme(){
        return praise_theme;
    }

    public void setPraise_theme(int praise_theme){
        this.praise_theme = praise_theme;
    }

    public int getPraise_countdown(){
        return praise_countdown;
    }

    public void setPraise_countdown(int praise_countdown){
        this.praise_countdown = praise_countdown;
    }

    public boolean isIs_link_mic(){
        return is_link_mic;
    }

    public void setIs_link_mic(boolean is_link_mic){
        this.is_link_mic = is_link_mic;
    }

    public UserBean getUser(){
        return user;
    }

    public void setUser(UserBean user){
        this.user = user;
    }

    public AdBean getAd(){
        return ad;
    }

    public void setAd(AdBean ad){
        this.ad = ad;
    }

    public FamilyBean getFamily(){
        return family;
    }

    public void setFamily(FamilyBean family){
        this.family = family;
    }

    public LinkMicBean getLink_mic(){
        return link_mic;
    }

    public void setLink_mic(LinkMicBean link_mic){
        this.link_mic = link_mic;
    }

    public static class UserBean{
        /**
         * uid : 8680435
         * uidx : 8680435
         * parent_uid : 8985396
         * avatar : http://yiqi1717-10009627.image.myqcloud.com/e002da06-dea8-4317-99a4-fab10735a383?imageView2/1/w/260/h/260
         * nickname : 玫瑰🌹小晟涵ԅ
         * gender : 2
         * age : 99
         * role_id : 2
         * credits : 327579
         * live_credits : 0
         * live_credits_1 : 0
         * live_adds : 23
         * live_shares : 2
         * live_magic : 0
         * province : 浙江省
         * city : 杭州市
         * sign : 吃好喝好长生不老🦁
         * excellent : false
         * lastver : 20171115
         * ico : {"vip":true,"heat":false,"follow":false,"official":false,"sale":false,"beautiful":false,"newreg":false}
         * grade : {"lv":18,"id":4,"grade":"冠","exp":135702,"next":149539,"upgrade":13837,"color":"","image":"","vip_image":"http://yiqi1717-10009627.image.myqcloud.com/584b8761-2b8e-4d76-9f8b-62eff016df2e","medal_id":1,"medal_image":"http://yiqi1717-10009627.image.myqcloud.com/70970c43-7d9f-4175-ba62-18e308d9f7f6"}
         * grade2 : {"lv":18,"id":4,"grade":"冠","exp":135702,"next":149539,"upgrade":13837,"color":"","image":"","vip_image":"http://yiqi1717-10009627.image.myqcloud.com/584b8761-2b8e-4d76-9f8b-62eff016df2e","medal_id":1,"medal_image":"http://yiqi1717-10009627.image.myqcloud.com/70970c43-7d9f-4175-ba62-18e308d9f7f6"}
         * certification : {"uid":0,"name":"","describe":"","status":0}
         * guardian : {"uid":0,"avatar":"http://yiqi1717-10009627.image.myqcloud.com/e8420c4b-6e32-4149-aa47-59e1a0021749","nickname":null}
         */

        private int uid;
        private int uidx;
        private int parent_uid;
        private String avatar;
        private String nickname;
        private int gender;
        private int age;
        private int role_id;
        private int credits;
        private int live_credits;
        private int live_credits_1;
        private int live_adds;
        private int live_shares;
        private int live_magic;
        private String province;
        private String city;
        private String sign;
        private boolean excellent;
        private String lastver;
        private IcoBean ico;
        private GradeBean grade;
        private Grade2Bean grade2;
        private CertificationBean certification;
        private GuardianBean guardian;

        public int getUid(){
            return uid;
        }

        public void setUid(int uid){
            this.uid = uid;
        }

        public int getUidx(){
            return uidx;
        }

        public void setUidx(int uidx){
            this.uidx = uidx;
        }

        public int getParent_uid(){
            return parent_uid;
        }

        public void setParent_uid(int parent_uid){
            this.parent_uid = parent_uid;
        }

        public String getAvatar(){
            return avatar;
        }

        public void setAvatar(String avatar){
            this.avatar = avatar;
        }

        public String getNickname(){
            return nickname;
        }

        public void setNickname(String nickname){
            this.nickname = nickname;
        }

        public int getGender(){
            return gender;
        }

        public void setGender(int gender){
            this.gender = gender;
        }

        public int getAge(){
            return age;
        }

        public void setAge(int age){
            this.age = age;
        }

        public int getRole_id(){
            return role_id;
        }

        public void setRole_id(int role_id){
            this.role_id = role_id;
        }

        public int getCredits(){
            return credits;
        }

        public void setCredits(int credits){
            this.credits = credits;
        }

        public int getLive_credits(){
            return live_credits;
        }

        public void setLive_credits(int live_credits){
            this.live_credits = live_credits;
        }

        public int getLive_credits_1(){
            return live_credits_1;
        }

        public void setLive_credits_1(int live_credits_1){
            this.live_credits_1 = live_credits_1;
        }

        public int getLive_adds(){
            return live_adds;
        }

        public void setLive_adds(int live_adds){
            this.live_adds = live_adds;
        }

        public int getLive_shares(){
            return live_shares;
        }

        public void setLive_shares(int live_shares){
            this.live_shares = live_shares;
        }

        public int getLive_magic(){
            return live_magic;
        }

        public void setLive_magic(int live_magic){
            this.live_magic = live_magic;
        }

        public String getProvince(){
            return province;
        }

        public void setProvince(String province){
            this.province = province;
        }

        public String getCity(){
            return city;
        }

        public void setCity(String city){
            this.city = city;
        }

        public String getSign(){
            return sign;
        }

        public void setSign(String sign){
            this.sign = sign;
        }

        public boolean isExcellent(){
            return excellent;
        }

        public void setExcellent(boolean excellent){
            this.excellent = excellent;
        }

        public String getLastver(){
            return lastver;
        }

        public void setLastver(String lastver){
            this.lastver = lastver;
        }

        public IcoBean getIco(){
            return ico;
        }

        public void setIco(IcoBean ico){
            this.ico = ico;
        }

        public GradeBean getGrade(){
            return grade;
        }

        public void setGrade(GradeBean grade){
            this.grade = grade;
        }

        public Grade2Bean getGrade2(){
            return grade2;
        }

        public void setGrade2(Grade2Bean grade2){
            this.grade2 = grade2;
        }

        public CertificationBean getCertification(){
            return certification;
        }

        public void setCertification(CertificationBean certification){
            this.certification = certification;
        }

        public GuardianBean getGuardian(){
            return guardian;
        }

        public void setGuardian(GuardianBean guardian){
            this.guardian = guardian;
        }

        public static class IcoBean{
            /**
             * vip : true
             * heat : false
             * follow : false
             * official : false
             * sale : false
             * beautiful : false
             * newreg : false
             */

            private boolean vip;
            private boolean heat;
            private boolean follow;
            private boolean official;
            private boolean sale;
            private boolean beautiful;
            private boolean newreg;

            public boolean isVip(){
                return vip;
            }

            public void setVip(boolean vip){
                this.vip = vip;
            }

            public boolean isHeat(){
                return heat;
            }

            public void setHeat(boolean heat){
                this.heat = heat;
            }

            public boolean isFollow(){
                return follow;
            }

            public void setFollow(boolean follow){
                this.follow = follow;
            }

            public boolean isOfficial(){
                return official;
            }

            public void setOfficial(boolean official){
                this.official = official;
            }

            public boolean isSale(){
                return sale;
            }

            public void setSale(boolean sale){
                this.sale = sale;
            }

            public boolean isBeautiful(){
                return beautiful;
            }

            public void setBeautiful(boolean beautiful){
                this.beautiful = beautiful;
            }

            public boolean isNewreg(){
                return newreg;
            }

            public void setNewreg(boolean newreg){
                this.newreg = newreg;
            }
        }

        public static class GradeBean{
            /**
             * lv : 18
             * id : 4
             * grade : 冠
             * exp : 135702
             * next : 149539
             * upgrade : 13837
             * color :
             * image :
             * vip_image : http://yiqi1717-10009627.image.myqcloud.com/584b8761-2b8e-4d76-9f8b-62eff016df2e
             * medal_id : 1
             * medal_image : http://yiqi1717-10009627.image.myqcloud.com/70970c43-7d9f-4175-ba62-18e308d9f7f6
             */

            private int lv;
            private int id;
            private String grade;
            private int exp;
            private int next;
            private int upgrade;
            private String color;
            private String image;
            private String vip_image;
            private int medal_id;
            private String medal_image;

            public int getLv(){
                return lv;
            }

            public void setLv(int lv){
                this.lv = lv;
            }

            public int getId(){
                return id;
            }

            public void setId(int id){
                this.id = id;
            }

            public String getGrade(){
                return grade;
            }

            public void setGrade(String grade){
                this.grade = grade;
            }

            public int getExp(){
                return exp;
            }

            public void setExp(int exp){
                this.exp = exp;
            }

            public int getNext(){
                return next;
            }

            public void setNext(int next){
                this.next = next;
            }

            public int getUpgrade(){
                return upgrade;
            }

            public void setUpgrade(int upgrade){
                this.upgrade = upgrade;
            }

            public String getColor(){
                return color;
            }

            public void setColor(String color){
                this.color = color;
            }

            public String getImage(){
                return image;
            }

            public void setImage(String image){
                this.image = image;
            }

            public String getVip_image(){
                return vip_image;
            }

            public void setVip_image(String vip_image){
                this.vip_image = vip_image;
            }

            public int getMedal_id(){
                return medal_id;
            }

            public void setMedal_id(int medal_id){
                this.medal_id = medal_id;
            }

            public String getMedal_image(){
                return medal_image;
            }

            public void setMedal_image(String medal_image){
                this.medal_image = medal_image;
            }
        }

        public static class Grade2Bean{
            /**
             * lv : 18
             * id : 4
             * grade : 冠
             * exp : 135702
             * next : 149539
             * upgrade : 13837
             * color :
             * image :
             * vip_image : http://yiqi1717-10009627.image.myqcloud.com/584b8761-2b8e-4d76-9f8b-62eff016df2e
             * medal_id : 1
             * medal_image : http://yiqi1717-10009627.image.myqcloud.com/70970c43-7d9f-4175-ba62-18e308d9f7f6
             */

            private int lv;
            private int id;
            private String grade;
            private int exp;
            private int next;
            private int upgrade;
            private String color;
            private String image;
            private String vip_image;
            private int medal_id;
            private String medal_image;

            public int getLv(){
                return lv;
            }

            public void setLv(int lv){
                this.lv = lv;
            }

            public int getId(){
                return id;
            }

            public void setId(int id){
                this.id = id;
            }

            public String getGrade(){
                return grade;
            }

            public void setGrade(String grade){
                this.grade = grade;
            }

            public int getExp(){
                return exp;
            }

            public void setExp(int exp){
                this.exp = exp;
            }

            public int getNext(){
                return next;
            }

            public void setNext(int next){
                this.next = next;
            }

            public int getUpgrade(){
                return upgrade;
            }

            public void setUpgrade(int upgrade){
                this.upgrade = upgrade;
            }

            public String getColor(){
                return color;
            }

            public void setColor(String color){
                this.color = color;
            }

            public String getImage(){
                return image;
            }

            public void setImage(String image){
                this.image = image;
            }

            public String getVip_image(){
                return vip_image;
            }

            public void setVip_image(String vip_image){
                this.vip_image = vip_image;
            }

            public int getMedal_id(){
                return medal_id;
            }

            public void setMedal_id(int medal_id){
                this.medal_id = medal_id;
            }

            public String getMedal_image(){
                return medal_image;
            }

            public void setMedal_image(String medal_image){
                this.medal_image = medal_image;
            }
        }

        public static class CertificationBean{
            /**
             * uid : 0
             * name :
             * describe :
             * status : 0
             */

            private int uid;
            private String name;
            private String describe;
            private int status;

            public int getUid(){
                return uid;
            }

            public void setUid(int uid){
                this.uid = uid;
            }

            public String getName(){
                return name;
            }

            public void setName(String name){
                this.name = name;
            }

            public String getDescribe(){
                return describe;
            }

            public void setDescribe(String describe){
                this.describe = describe;
            }

            public int getStatus(){
                return status;
            }

            public void setStatus(int status){
                this.status = status;
            }
        }

        public static class GuardianBean{
            /**
             * uid : 0
             * avatar : http://yiqi1717-10009627.image.myqcloud.com/e8420c4b-6e32-4149-aa47-59e1a0021749
             * nickname : null
             */

            private int uid;
            private String avatar;
            private Object nickname;

            public int getUid(){
                return uid;
            }

            public void setUid(int uid){
                this.uid = uid;
            }

            public String getAvatar(){
                return avatar;
            }

            public void setAvatar(String avatar){
                this.avatar = avatar;
            }

            public Object getNickname(){
                return nickname;
            }

            public void setNickname(Object nickname){
                this.nickname = nickname;
            }
        }
    }

    public static class AdBean{
        /**
         * title :
         * avatar :
         * cover :
         * parameters :
         */

        private String title;
        private String avatar;
        private String cover;
        private String parameters;

        public String getTitle(){
            return title;
        }

        public void setTitle(String title){
            this.title = title;
        }

        public String getAvatar(){
            return avatar;
        }

        public void setAvatar(String avatar){
            this.avatar = avatar;
        }

        public String getCover(){
            return cover;
        }

        public void setCover(String cover){
            this.cover = cover;
        }

        public String getParameters(){
            return parameters;
        }

        public void setParameters(String parameters){
            this.parameters = parameters;
        }
    }

    public static class FamilyBean{
        /**
         * uid : 8985396
         * name : 玫瑰🌹家族
         * slogan : 玫瑰🌹
         * notice : 大量招聘主播，有意向加V联系：79480908
         * avatar : http://yiqi1717-10009627.image.myqcloud.com/db661d50-f3c8-46c9-a02f-e9189ec02b1c
         * displayorder_trend : 37
         * template :
         * livelist : []
         */

        private int uid;
        private String name;
        private String slogan;
        private String notice;
        private String avatar;
        private int displayorder_trend;
        private String template;
        private List<?> livelist;

        public int getUid(){
            return uid;
        }

        public void setUid(int uid){
            this.uid = uid;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public String getSlogan(){
            return slogan;
        }

        public void setSlogan(String slogan){
            this.slogan = slogan;
        }

        public String getNotice(){
            return notice;
        }

        public void setNotice(String notice){
            this.notice = notice;
        }

        public String getAvatar(){
            return avatar;
        }

        public void setAvatar(String avatar){
            this.avatar = avatar;
        }

        public int getDisplayorder_trend(){
            return displayorder_trend;
        }

        public void setDisplayorder_trend(int displayorder_trend){
            this.displayorder_trend = displayorder_trend;
        }

        public String getTemplate(){
            return template;
        }

        public void setTemplate(String template){
            this.template = template;
        }

        public List<?> getLivelist(){
            return livelist;
        }

        public void setLivelist(List<?> livelist){
            this.livelist = livelist;
        }
    }

    public static class LinkMicBean{
        /**
         * beauty : true
         * link_mic_disturb : false
         * live_info : {"uid":0,"pushUrl":"http://yiqipzbpush.biubiuzhibo.com:7788/publish/trans/pajia","linkUrl":"pzsp://yiqipzbpush.biubiuzhibo.com:7788/live/ld/trans/pajia","encUrl":"pzsp://yiqipzbflv.biubiuzhibo.com:8000/live/ld/trans/pajia","slot":0,"room_id":0,"push_ndselect":3,"pull_ndselect":1}
         * user_list : []
         */

        private boolean beauty;
        private boolean link_mic_disturb;
        private LiveInfoBean live_info;
        private List<?> user_list;

        public boolean isBeauty(){
            return beauty;
        }

        public void setBeauty(boolean beauty){
            this.beauty = beauty;
        }

        public boolean isLink_mic_disturb(){
            return link_mic_disturb;
        }

        public void setLink_mic_disturb(boolean link_mic_disturb){
            this.link_mic_disturb = link_mic_disturb;
        }

        public LiveInfoBean getLive_info(){
            return live_info;
        }

        public void setLive_info(LiveInfoBean live_info){
            this.live_info = live_info;
        }

        public List<?> getUser_list(){
            return user_list;
        }

        public void setUser_list(List<?> user_list){
            this.user_list = user_list;
        }

        public static class LiveInfoBean{
            /**
             * uid : 0
             * pushUrl : http://yiqipzbpush.biubiuzhibo.com:7788/publish/trans/pajia
             * linkUrl : pzsp://yiqipzbpush.biubiuzhibo.com:7788/live/ld/trans/pajia
             * encUrl : pzsp://yiqipzbflv.biubiuzhibo.com:8000/live/ld/trans/pajia
             * slot : 0
             * room_id : 0
             * push_ndselect : 3
             * pull_ndselect : 1
             */

            private int uid;
            private String pushUrl;
            private String linkUrl;
            private String encUrl;
            private int slot;
            private int room_id;
            private int push_ndselect;
            private int pull_ndselect;

            public int getUid(){
                return uid;
            }

            public void setUid(int uid){
                this.uid = uid;
            }

            public String getPushUrl(){
                return pushUrl;
            }

            public void setPushUrl(String pushUrl){
                this.pushUrl = pushUrl;
            }

            public String getLinkUrl(){
                return linkUrl;
            }

            public void setLinkUrl(String linkUrl){
                this.linkUrl = linkUrl;
            }

            public String getEncUrl(){
                return encUrl;
            }

            public void setEncUrl(String encUrl){
                this.encUrl = encUrl;
            }

            public int getSlot(){
                return slot;
            }

            public void setSlot(int slot){
                this.slot = slot;
            }

            public int getRoom_id(){
                return room_id;
            }

            public void setRoom_id(int room_id){
                this.room_id = room_id;
            }

            public int getPush_ndselect(){
                return push_ndselect;
            }

            public void setPush_ndselect(int push_ndselect){
                this.push_ndselect = push_ndselect;
            }

            public int getPull_ndselect(){
                return pull_ndselect;
            }

            public void setPull_ndselect(int pull_ndselect){
                this.pull_ndselect = pull_ndselect;
            }
        }
    }
}
