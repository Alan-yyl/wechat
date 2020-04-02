package cn.alan.wechat.Controller;

import cn.alan.wechat.Model.AccessToken;
import cn.alan.wechat.utill.NetManagerUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

/**
 * 该类用于获取access_token
 *
 * @auther 杨亚龙
 * @date 2020/4/1 19:18
 */
public class WxService {
    //获取ACCESS_TOKEN_URL的URL
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    //微信公众号的APPID
    private static final String APPID = "wx0861237e72c0e39d";
    //微信公众号的密码
    private static final String APPSECRET = "cef11713f7031b5e789ce5b62de1cb0e";
    //当前的access_token
    private static AccessToken currentAccessToken;

    /**
     * 更新CurrentAccessToken
     */
    private static void getCurrentAccessToken() {
        //拼接请求链接
        String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);

        //使用"GET"方法获取数据
        String jsonStr = null;
        try {
            jsonStr = NetManagerUtil.net(url, null, "GET");
            //将json字符串转为对象
            JSONObject jsonObject = JSON.parseObject(jsonStr);
            AccessToken accessToken = new AccessToken(jsonObject.getString("access_token"), jsonObject.getString("expires_in"));
            currentAccessToken = accessToken;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取AccessToken
     * @return
     */
    public static String getAccessToken(){
    //如果access_token不存在或者过期了，就获取token
        if (currentAccessToken == null||currentAccessToken.isExpires()) {
            getCurrentAccessToken();
        }
        return currentAccessToken.getToken();
    }


}
