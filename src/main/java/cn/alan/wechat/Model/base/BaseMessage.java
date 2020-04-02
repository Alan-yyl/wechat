package cn.alan.wechat.Model.base;

/**
 * 定义消息的基本属性
 *
 * @auther 杨亚龙
 * @date 2020/3/22 13:35
 */
public class BaseMessage {
    private String ToUserName;
    private String FromUserName;
    private long CreateTime;
    private String MsgType;
    private long MsgId;

    @Override
    public String toString() {
        return "BaseMessage{" +
                "ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                ", MsgId=" + MsgId +
                '}';
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}
