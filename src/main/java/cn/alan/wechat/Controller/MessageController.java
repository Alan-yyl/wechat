package cn.alan.wechat.Controller;

import cn.alan.wechat.Model.TextMessage;
import cn.alan.wechat.utill.MessageUtil;

import java.util.Date;
import java.util.Map;

/**
 * @auther 杨亚龙
 * @date 2020/3/22 13:41
 */
public class MessageController {
    public static String processMessage(Map<String, String> map) {
        String openid = map.get("FromUserName"); //用户 openid
        String mpid = map.get("ToUserName");   //公众号原始 ID
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
            //普通文本消息
            TextMessage txtmsg = new TextMessage();
            txtmsg.setToUserName(openid);
            txtmsg.setFromUserName(mpid);
            txtmsg.setCreateTime(new Date().getTime());
            txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            txtmsg.setContent("谢谢关注，你的分销码是"+openid);
            return MessageUtil.textMessageToXml(txtmsg);
        }else{
            //空文本
            TextMessage txtmsg = new TextMessage();
            txtmsg.setToUserName(openid);
            txtmsg.setFromUserName(mpid);
            txtmsg.setCreateTime(new Date().getTime());
            txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            txtmsg.setContent("");
            return MessageUtil.textMessageToXml(txtmsg);
        }
    }
    // public  static String processEvent(Map<String, String> map) {
    //     //在这里处理事件
    //     System.out.println("MessageController.processEvent");
    //     return "处理事件";
    // }
}
