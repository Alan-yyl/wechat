package cn.alan.wechat.model;

import cn.alan.wechat.model.base.BaseButton;

/**
 * @author 杨亚龙
 * @date 2020/4/2 1:16
 */
public class ViewButton extends BaseButton {
    private String type="view";

    //跳转地址
    private String url="";

    public ViewButton(String name, String url) {
        super(name);
        this.url = url;
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
}
