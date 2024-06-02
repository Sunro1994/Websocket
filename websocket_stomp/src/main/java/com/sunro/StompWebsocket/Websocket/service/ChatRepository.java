package com.sunro.StompWebsocket.Websocket.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunro.StompWebsocket.Websocket.dto.ChatRoom;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.*;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ChatRepository {

    private Map<String, ChatRoom> chatRooms;

    @PostConstruct
    public void init() {
        chatRooms = new HashMap<>();
    }

    public List<ChatRoom> findAllRoom() {
        return new ArrayList<>(chatRooms.values());
    }

    public ChatRoom findRoomById(String roomId) {
        return chatRooms.get(roomId);
    }

    public ChatRoom createRoom(String name) {
        ChatRoom chatroom = ChatRoom.create(name);
        chatRooms.put(chatroom.getRoomId(), chatroom);
        return chatroom;
    }

}
