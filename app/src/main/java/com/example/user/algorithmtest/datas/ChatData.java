package com.example.user.algorithmtest.datas;

/**
 * Created by user on 2017-08-11.
 */

public class ChatData {
    private boolean isSentByMe; // 내가보내면 T, 컴퓨터 F
    private String messageText; // 메시지의 내용 저장

    public ChatData() {
    }

    public ChatData(boolean isSentByMe, String messageText) {
        this.isSentByMe = isSentByMe;
        this.messageText = messageText;
    }

    public boolean isSentByMe() {
        return isSentByMe;
    }

    public void setSentByMe(boolean sentByMe) {
        isSentByMe = sentByMe;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
