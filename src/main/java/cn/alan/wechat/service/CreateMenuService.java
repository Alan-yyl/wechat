package cn.alan.wechat.service;


import cn.alan.wechat.model.ClickButton;
import cn.alan.wechat.model.MiniProgramButton;
import cn.alan.wechat.model.SubButton;
import cn.alan.wechat.model.ViewButton;
import cn.alan.wechat.utill.NetManagerUtil;
import cn.alan.wechat.utill.WxButton;
import com.alibaba.fastjson.JSONObject;

import javax.swing.text.View;

/**
 * 创建自定义菜单
 *
 * @author 杨亚龙
 * @date 2020/4/2 1:44
 */
public class CreateMenuService {
    private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    //第一项菜单
    private static final String ONE_MENU_TITLE = "璞知创品";
    private static final String ONE_MENU_APPID = "wx8c95948e72bbb244";
    private static final String ONE_MENU_PAGEPATH = "pages/home/dashboard/index";

    //第二项菜单
    private static final String TWO_MENU_TITLE = "联系我们";
    private static final String TWO_MENU_SUBTITLE_ONE = "关于我们";
    private static final String TWO_MENU_SUBTITLE_ONE_URL = "" +
            "https://mp.weixin.qq.com/s?__biz=Mzg2NTE2NDA1Mw==&mid=2247485058&idx=1&sn=8778f60ef29bc7dd1a6e9fb478143370&chksm=ce5f08f8f92881ee5ff7b2916b43fb229e1f4478810a33962a1c43606bfdf7d3e4514f575b29&token=913778013&lang=zh_CN#rd";
    private static final String TWO_MENU_SUBTITLE_TWO = "璞知简介";
    private static final String TWO_MENU_SUBTITLE_TWO_URL = "" +
            "https://mp.weixin.qq.com/s?__biz=Mzg2NTE2NDA1Mw==&mid=2247485058&idx=1&sn=8778f60ef29bc7dd1a6e9fb478143370&chksm=ce5f08f8f92881ee5ff7b2916b43fb229e1f4478810a33962a1c43606bfdf7d3e4514f575b29&token=913778013&lang=zh_CN#rd";
    private static final String TWO_MENU_SUBTITLE_THREE = "联系我们";
    private static final String TWO_MENU_SUBTITLE_THREE_KEY = "联系我们KEY";

    //第三项菜单
    private static final String THREE_MENU_TITLE = "我的";
    private static final String THREE_MENU_SUBTITLE_ONE = "邀请码";
    private static final String THREE_MENU_SUBTITLE_ONEKEY = "邀请码KEY";


    public static void main(String[] args) {
        creatWxButton();
    }


    private static void creatWxButton() {
        //第一个菜单
        MiniProgramButton oneButton = new MiniProgramButton(ONE_MENU_TITLE, ONE_MENU_PAGEPATH, ONE_MENU_APPID);
        System.out.println(oneButton);
        //第二个菜单
        SubButton twoButton = new SubButton(TWO_MENU_TITLE);
        ClickButton contactUs = new ClickButton(TWO_MENU_SUBTITLE_THREE, TWO_MENU_SUBTITLE_THREE_KEY);
        ViewButton aboutUs = new ViewButton(TWO_MENU_SUBTITLE_ONE, TWO_MENU_SUBTITLE_ONE_URL);
        ViewButton instructPZ = new ViewButton(TWO_MENU_SUBTITLE_TWO, TWO_MENU_SUBTITLE_TWO_URL);
        //将子按钮添加到列表中
        twoButton.getSub_button().add(contactUs);
        twoButton.getSub_button().add(aboutUs);
        twoButton.getSub_button().add(instructPZ);
        //第三个菜单
        SubButton threeButton = new SubButton(THREE_MENU_TITLE);
        //第三个菜单的子菜单
        ClickButton subButtonOne = new ClickButton(THREE_MENU_SUBTITLE_ONE, THREE_MENU_SUBTITLE_ONEKEY);
        //将子按钮增添到列表中
        threeButton.getSub_button().add(subButtonOne);
        //添加到button对象中
        WxButton wxButton = new WxButton();
        wxButton.getButton().add(oneButton);
        wxButton.getButton().add(twoButton);
        wxButton.getButton().add(threeButton);
        System.out.println("CreateMenuService.creatWxButton" + wxButton.toString());
        //转json
        String jsonStr = JSONObject.toJSONString(wxButton);
        //替换access_token
        String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", WxService.getAccessToken());
        //调用网络请求
        NetManagerUtil.post(url, jsonStr);
    }


}
