package cn.alan.wechat.controller;

import cn.alan.wechat.model.UserInfo;
import cn.alan.wechat.service.UserService;
import cn.alan.wechat.utill.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserService userService;

    @PostMapping(value = "/verify_wx_token", produces = "application/xml;charset=utf-8")
    public String handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("请求体XML：");
        System.out.println(request);

        request.setCharacterEncoding("UTF-8");
        Map<String, String> map = MessageUtil.parseXml(request);
        System.out.println("发来的消息" + map);
        System.out.println(userService.findById(map.get("FromUserName")));

        //根据消息类型进行推送
        if (map.get("Event") != null && map.get("Event").equals("subscribe")) {
            map.put("Content", "");
            //用户关注公众号
            UserInfo userInfo1 = userService.findById(map.get("FromUserName"));
            if (userInfo1 != null) {
                //用户已经注册
                System.out.println("用户已注册");
                System.out.println(map.get("Content"));
                map.replace("Content", "欢迎回来，邀请码：" + userInfo1.getDistributionCode());
                return MessageController.processMessage(map);
            } else {
                //用户未注册
                System.out.println("用户未注册");
                UserInfo userInfo = userService.register(map);
                System.out.println(userInfo);
                map.replace("Content", "谢谢关注，邀请码：" + userInfo.getDistributionCode());
                return MessageController.processMessage(map);
            }
        } else if (map.get("MsgType") != null && map.get("MsgType").equals("text")) {
            System.out.println("用户发送了一条消息过来");
            map.replace("Content", "你好");
            return MessageController.processMessage(map);
        } else if (map.get("EventKey") != null && map.get("EventKey").equals("邀请码KEY")) {
            UserInfo userInfo = userService.findById(map.get("FromUserName"));
            map.put("Content", "邀请码：" + userInfo.getDistributionCode());
            System.out.println("用户点击了邀请码按钮");
            System.out.println(map);
            return MessageController.processMessage(map);
        } else if (map.get("EventKey") != null && map.get("EventKey").equals("联系我们KEY")) {
            map.put("Content", "请在公众号直接回复以下序号，获取对应校区的联系方式哦！\n" +
                    "1、上海第二工业大学\n" +
                    "2、上海商学院\n" +
                    "3、上海工程技术大学\n" +
                    "4、上海电机学院\n" +
                    "5、东华大学\n" +
                    "6、华东政法大学\n" +
                    "7、上海应用技术大学\n" +
                    "8、上海立信金融学院\n" +
                    "9、上海建桥学院\n" +
                    "10、上海海事大学\n" +
                    "11、上海海洋大学\n" +
                    "12、上海电力学院\n" +
                    "13、上海健康医学院\n" +
                    "14、上海城建职业学院\n" +
                    "15、上海理工大学");
            System.out.println("PostController.handler" + "用户点击了联系我们按钮");
            System.out.println("PostController.handler"+map);
            return MessageController.processMessage(map);
        } else {
            return "";
        }

    }
}
