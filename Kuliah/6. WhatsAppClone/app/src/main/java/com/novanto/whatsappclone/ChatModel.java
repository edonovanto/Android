package com.novanto.whatsappclone;

public class ChatModel {
    private String name, time, chat;

    public ChatModel (String name,String time, String chat){
        this.name = name;
        this.time = time;
        this.chat = chat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }
}
