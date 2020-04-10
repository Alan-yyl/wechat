package cn.alan.wechat.utill;

import cn.alan.wechat.model.base.BaseButton;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于最终生成JSON字符串的类
 * @author 杨亚龙
 * @date 2020/4/2 1:22
 */
public class WxButton {
    private List<BaseButton> button=new ArrayList<>();

    public List<BaseButton> getButton() {
        return button;
    }

    public void setButton(List<BaseButton> button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "WxButton{" +
                "button=" + button +
                '}';
    }
}
