package cn.alan.wechat.Model;

import cn.alan.wechat.Model.base.BaseMessage;

/**
 * 文本消息
 * @auther 杨亚龙
 * @date 2020/3/22 13:36
 */
public class TextMessage extends BaseMessage {
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

}
