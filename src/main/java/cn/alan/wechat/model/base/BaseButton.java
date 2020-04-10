package cn.alan.wechat.model.base;

/**
 * 按钮基类
 * @author 杨亚龙
 * @date 2020/4/2 1:11
 */
public class BaseButton {
    //按钮名字
    private String name;

    public BaseButton(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BaseButton{" +
                "name='" + name + '\'' +
                '}';
    }
}
