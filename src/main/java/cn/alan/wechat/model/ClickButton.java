package cn.alan.wechat.model;

import cn.alan.wechat.model.base.BaseButton;

/**
 * 创建click按钮类
 * @author 杨亚龙
 * @date 2020/4/2 1:13
 */
public class ClickButton extends BaseButton {
    private String type="click";

    //按钮唯一键
    private String key;

    public ClickButton(String name, String key) {
        super(name);
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "ClickButton{" +
                "type='" + type + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
