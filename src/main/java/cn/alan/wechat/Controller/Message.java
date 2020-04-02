package cn.alan.wechat.Controller;

/**
 * @auther 杨亚龙
 * @date 2020/3/22 13:13
 */
public class Message {
    String message = "    <xml>\n" +
            "  <ToUserName><![CDATA[gh_c2fb695c1961]]></ToUserName>\n" +
            "  <FromUserName><![CDATA[oFblh5ss2HFn1vZobmMdYnPDq4fc]]></FromUserName>\n" +
            "  <CreateTime>12345678</CreateTime>\n" +
            "  <MsgType><![CDATA[text]]></MsgType>\n" +
            "  <Content><![CDATA[你好]]></Content>\n" +
            "</xml>";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
