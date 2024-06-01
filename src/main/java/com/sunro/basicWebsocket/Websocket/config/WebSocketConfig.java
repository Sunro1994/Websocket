package com.sunro.basicWebsocket.Websocket.config;

// 패키지 선언입니다. 이 클래스는 com.sunro.basicWebsocket.Websocket.config 패키지에 속합니다.

import com.sunro.basicWebsocket.Websocket.handler.WebSockChatHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

// 필요한 클래스와 인터페이스를 임포트합니다.

@RequiredArgsConstructor
// Lombok의 @RequiredArgsConstructor 애노테이션을 사용하여 모든 final 필드 또는 @NonNull 필드에 대해 생성자를 자동으로 생성합니다.

@Configuration
// @Configuration 애노테이션을 사용하여 이 클래스가 하나 이상의 @Bean 메서드를 가지며 Spring IoC 컨테이너에서 빈 정의의 소스로 사용됨을 나타냅니다.

@EnableWebSocket
// @EnableWebSocket 애노테이션을 사용하여 웹소켓을 활성화합니다.

public class WebSocketConfig implements WebSocketConfigurer {
    // WebSocketConfig 클래스는 WebSocketConfigurer 인터페이스를 구현합니다. 이 인터페이스는 웹소켓 핸들러를 등록하는 메서드를 제공합니다.

    private final WebSockChatHandler webSockChatHandler;
    // WebSockChatHandler 타입의 final 필드를 선언합니다. 이 필드는 생성자 주입을 통해 초기화됩니다.

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // WebSocketHandlerRegistry를 사용하여 웹소켓 핸들러를 등록하는 메서드입니다.

        registry.addHandler(webSockChatHandler, "/ws/chat").setAllowedOrigins("*");
        // webSockChatHandler 핸들러를 "/ws/chat" 경로에 등록합니다.
        // setAllowedOrigins("*")를 사용하여 모든 도메인에서의 웹소켓 연결을 허용합니다.
    }
}
