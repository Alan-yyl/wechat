package cn.alan.wechat.model;

import cn.alan.wechat.model.base.BaseButton;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨亚龙
 * @date 2020/4/2 1:18
 */
public class SubButton extends BaseButton {
    private List<BaseButton> sub_button=new ArrayList<>();

    public SubButton(String name) {
        super(name);
    }

    public List<BaseButton> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<BaseButton> sub_button) {
        this.sub_button = sub_button;
    }

    @Override
    public String toString() {
        return "SubButton{" +
                "sub_button=" + sub_button +
                '}';
    }
}
