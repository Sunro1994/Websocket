package com.sunro.StompWebsocket.Websocket.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ChatRoom {

    private String roomId;
    private String name;


    public static ChatRoom create(String name) {
        ChatRoom room = new ChatRoom();
        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }




}
