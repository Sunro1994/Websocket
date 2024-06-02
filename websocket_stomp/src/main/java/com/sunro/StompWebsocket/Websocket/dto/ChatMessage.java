package com.sunro.StompWebsocket.Websocket.dto;

import lombok.Data;

@Data
public class ChatMessage {
    // ChatMessage 클래스는 웹소켓을 통해 주고받는 채팅 메시지를 나타냅니다.

    // 메시지 타입: 입장, 채팅
    public enum MessageType{
        ENTER, JOIN, TALK
    }
    // MessageType 열거형을 정의합니다. 이 열거형은 메시지 타입을 나타내며, "ENTER"와 "TALK" 값을 가질 수 있습니다.

    private MessageType type;
    // type 필드는 메시지의 타입을 나타냅니다. MessageType 열거형 타입입니다.

    private String roomId;
    // roomId 필드는 메시지가 전송되는 채팅방의 ID를 나타냅니다. String 타입입니다.

    private String sender;
    // sender 필드는 메시지를 보낸 사용자의 이름을 나타냅니다. String 타입입니다.

    private String message;
    // message 필드는 실제 메시지 내용을 나타냅니다. String 타입입니다
}
