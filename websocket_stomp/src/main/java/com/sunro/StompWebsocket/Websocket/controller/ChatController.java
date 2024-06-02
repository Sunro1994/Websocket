package com.sunro.StompWebsocket.Websocket.controller;


import com.sunro.StompWebsocket.Websocket.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat/message")
    public void message(ChatMessage chatMessage) {
        if(ChatMessage.MessageType.JOIN.equals(chatMessage.getType())) {
        chatMessage.setMessage(chatMessage.getSender() + "님이 입장하셨습니다.");

        }
        messagingTemplate.convertAndSend("/sub/chat/room/"+chatMessage.getRoomId(),chatMessage);

    }
}
