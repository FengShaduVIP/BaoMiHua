package com.baomihua.entity;

/**
 * Created by BaoMi花 on 2018/10/6.
 */
public class TextMessage {
    // 消息内容
    private String Content;
    // 公众帐号
    private String ToUserName;

    // 发送方帐号（open_id）
    private String FromUserName;

    private String CreateTime;
    // 消息类型
    private String MsgType;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
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

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
}
