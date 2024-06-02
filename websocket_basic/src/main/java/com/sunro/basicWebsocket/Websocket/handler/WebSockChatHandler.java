package com.sunro.basicWebsocket.Websocket.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunro.basicWebsocket.Websocket.dto.ChatMessage;
import com.sunro.basicWebsocket.Websocket.dto.ChatRoom;
import com.sunro.basicWebsocket.Websocket.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSockChatHandler extends TextWebSocketHandler {
    // WebSockChatHandler 클래스는 Spring의 TextWebSocketHandler를 확장하여 웹소켓 텍스트 메시지를 처리합니다.

        private final ObjectMapper objectMapper;
        private final ChatService chatService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        // handleTextMessage 메서드는 WebSocketSession과 TextMessage를 매개변수로 받습니다.
        // WebSocketSession은 클라이언트와의 웹소켓 세션을 나타내며, TextMessage는 수신된 텍스트 메시지를 나타냅니다.

        String payload = message.getPayload();
        // message.getPayload()를 호출하여 수신된 메시지의 페이로드(내용)를 문자열로 가져옵니다.

        log.info("payload = {}", payload);
        // 수신된 메시지의 페이로드를 로그로 출력합니다.
        // {}는 플레이스홀더로, payload 값이 로그 메시지에 삽입됩니다.

        /**
         *  이전 로직은 단일 세션에서 수행되는 코드였으나, 여러 세션에서 채팅이 가능하도록 변경하여 이 코드를 사용하지 않습니다.
         TextMessage textMessage = new TextMessage("Welcome");
         클라이언트에게 보낼 텍스트 메시지를 생성합니다. 여기서는 "Welcome"이라는 간단한 문자열을 메시지로 설정합니다.

         session.sendMessage(textMessage);
         session.sendMessage()를 호출하여 생성된 텍스트 메시지를 클라이언트에게 전송합니다.
         */

        ChatMessage chatMessage = objectMapper.readValue(payload,ChatMessage.class);
        ChatRoom chatRoom = chatService.findRoomById(chatMessage.getRoomId());
        chatRoom.handlerActions(session,chatMessage,chatService);
    }
}

