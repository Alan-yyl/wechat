package cn.alan.wechat.model;

import cn.alan.wechat.model.base.BaseButton;

/**
 * @author 杨亚龙
 * @date 2020/4/2 1:35
 */
public class MiniProgramButton extends BaseButton {
    private String type = "miniprogram";
    //微信小程序链接
    private String url="http://mp.weixin.qq.com";

    //微信小程序名字
    private String name;
    //微信小程序页面路劲
    private String pagepath;
    //微信小程序appid
    private String appid;

    public MiniProgramButton(String name, String pagepath, String appid) {
        super(name);
        this.name = name;
        this.pagepath = pagepath;
        this.appid = appid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    @Override
    public String toString() {
        return "MiniProgramButton{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", path='" + pagepath + '\'' +
                ", appid='" + appid + '\'' +
                '}';
    }
}
