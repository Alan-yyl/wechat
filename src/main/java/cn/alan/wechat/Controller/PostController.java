package cn.alan.wechat.Controller;

import cn.alan.wechat.utill.MessageUtil;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

/**
 * @auther 杨亚龙
 * @date 2020/3/22 1:22
 */
@RestController
public class PostController {
    @PostMapping(value = "/verify_wx_token",produces = "application/xml;charset=utf-8")
    public String handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("PostController.handler");
        request.setCharacterEncoding("UTF-8");
        Map<String, String> map = MessageUtil.parseXml(request);

        // request.setCharacterEncoding("UTF-8");
        // response.setCharacterEncoding("UTF-8");
        // PrintWriter out = response.getWriter();
        // Map<String, String> parseXml = PostController.parseXml(request);
        String msgType = map.get("MsgType");
        String content = map.get("Content");
        String fromUserName = map.get("FromUserName");
        String ToUserName = map.get("ToUserName");
        System.out.println("msgType:"+msgType);
        System.out.println("content:"+content);
        System.out.println("用户的微信号fromUserName:"+fromUserName);
        System.out.println("公众号的编号ToUserName:"+ToUserName);

        if (MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(msgType)) {
            return MessageController.processMessage(map);
        }
        return "";
    }

}
