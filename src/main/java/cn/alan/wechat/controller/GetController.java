package cn.alan.wechat.controller;

import cn.alan.wechat.utill.CheckUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author 杨亚龙
 * @date 2020/3/22 1:15
 */
@RestController
public class GetController {
    @GetMapping("/verify_wx_token")
    public void login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        System.out.println("GetController.login");
        request.setCharacterEncoding("UTF-8");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        System.out.println(signature + "  " + timestamp + "  " + nonce + "    " + echostr);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            System.out.println(CheckUtil.checkSignature(signature, timestamp, nonce));
            if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
                out.write(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
