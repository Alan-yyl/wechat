package cn.alan.wechat.service;


import cn.alan.wechat.model.ClickButton;
import cn.alan.wechat.model.MiniProgramButton;
import cn.alan.wechat.model.SubButton;
import cn.alan.wechat.utill.NetManagerUtil;
import cn.alan.wechat.utill.WxButton;
import com.alibaba.fastjson.JSONObject;

/**
 * 创建自定义菜单
 * @author 杨亚龙
 * @date 2020/4/2 1:44
 */
public class CreateMenuService {
    private static final String CREATE_MENU_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    //第一项菜单
    private static final String ONE_MENU_TITLE="璞知创品";
    private static final String ONE_MENU_APPID="wx8c95948e72bbb244";
    private static final String ONE_MENU_PAGEPATH="pages/home/dashboard/index";

    //第二项菜单
    private static final String TWO_MENU_TITLE="0元水果";
    private static final String TWO_MENU_APPID="wx8c95948e72bbb244";
    private static final String TWO_MENU_PAGEPATH="packages/goods/detail/index?type=helpcut&alias=3eo60i6g69oid&activityId=94237&umpAlias=16oi1uz7&umpType=helpCut";

    //第三项菜单
    private static final String  THREE_MENU_TITLE="我的";
    private static final String THREE_MENU_SUBTITLE_ONE="分销码";
    private static final String THREE_MENU_SUBTITLE_ONEKEY="分销码KEY";


    public static void main(String[] args) {
        // creatWxButton();
    }


    private static void creatWxButton() {
        //第一个菜单
        MiniProgramButton oneButton= new MiniProgramButton(ONE_MENU_TITLE,ONE_MENU_PAGEPATH,ONE_MENU_APPID);
        System.out.println(oneButton);
        //第二个菜单
        MiniProgramButton twoButton= new MiniProgramButton(TWO_MENU_TITLE,TWO_MENU_PAGEPATH,TWO_MENU_APPID);
        //第三个菜单
        SubButton threeButton = new SubButton(THREE_MENU_TITLE);
        //第三个菜单的子菜单
        ClickButton subButtonOne = new ClickButton(THREE_MENU_SUBTITLE_ONE,THREE_MENU_SUBTITLE_ONEKEY);
        //将子按钮增添到列表中
        threeButton.getSub_button().add(subButtonOne);
        //添加到button对象中
        WxButton wxButton = new WxButton();
        wxButton.getButton().add(oneButton);
        wxButton.getButton().add(twoButton);
        wxButton.getButton().add(threeButton);
        System.out.println("CreateMenuService.creatWxButton"+wxButton.toString());
        //转json
        String jsonStr = JSONObject.toJSONString(wxButton);
        //替换access_token
        String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", WxService.getAccessToken());
        //调用网络请求
        NetManagerUtil.post(url,jsonStr);
    }









}
