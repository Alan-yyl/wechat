package cn.alan.wechat.controller;

import cn.alan.wechat.model.TextMessage;
import cn.alan.wechat.utill.MessageUtil;

import java.util.Date;
import java.util.Map;

/**
 * @auther 杨亚龙
 * @date 2020/3/22 13:41
 */
public class MessageController {
    public static String processMessage(Map<String, String> map) {
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)||map.get("Event").equals("subscribe")||map.get("EventKey").equals("邀请码KEY")||map.get("EventKey").equals("联系我们KEY")) {
            //普通文本消息
            TextMessage txtmsg = new TextMessage();
            txtmsg.setToUserName(map.get("FromUserName"));
            txtmsg.setFromUserName(map.get("ToUserName"));
            txtmsg.setCreateTime(new Date().getTime());
            txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            txtmsg.setContent(map.get("Content"));
            System.out.println(map.toString());
            System.out.println(map.get("Content"));
            System.out.println("txtmsg");
            System.out.println(txtmsg);
            return MessageUtil.textMessageToXml(txtmsg);
        }else{
            return "";
        }
    }
}
