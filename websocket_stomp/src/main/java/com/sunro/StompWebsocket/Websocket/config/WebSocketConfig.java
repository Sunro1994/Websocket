package com.sunro.StompWebsocket.Websocket.config;

// 패키지 선언입니다. 이 클래스는 com.sunro.StompWebsocket.Websocket.config 패키지에 속합니다.

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

// 필요한 클래스와 인터페이스를 임포트합니다.

@RequiredArgsConstructor
// Lombok의 @RequiredArgsConstructor 애노테이션을 사용하여 모든 final 필드 또는 @NonNull 필드에 대해 생성자를 자동으로 생성합니다.

@Configuration
// @Configuration 애노테이션을 사용하여 이 클래스가 하나 이상의 @Bean 메서드를 가지며 Spring IoC 컨테이너에서 빈 정의의 소스로 사용됨을 나타냅니다.
@EnableWebSocketMessageBroker
// @EnableWebSocketMessageBroker 애노테이션을 사용하여 웹소켓 메시지 브로커를 활성화합니다.
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    // WebSocketConfig 클래스는 WebSocketMessageBrokerConfigurer 인터페이스를 구현합니다. 이 인터페이스는 STOMP 프로토콜을 사용하는 웹소켓 메시지 브로커를 설정하는 메서드를 제공합니다.

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // configureMessageBroker 메서드는 메시지 브로커를 설정합니다.

        registry.enableSimpleBroker("/sub");
        // enableSimpleBroker 메서드는 "/sub" 경로를 구독하는 간단한 메시지 브로커를 활성화합니다.

        registry.setApplicationDestinationPrefixes("/pub");
        // setApplicationDestinationPrefixes 메서드는 클라이언트가 "/pub" 경로로 시작하는 목적지로 메시지를 전송하도록 설정합니다.
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // registerStompEndpoints 메서드는 STOMP 엔드포인트를 등록합니다.

        registry.addEndpoint("/ws-stomp").setAllowedOriginPatterns("*").withSockJS();
        // addEndpoint 메서드는 "/ws-stomp" 엔드포인트를 추가합니다.
        // setAllowedOrigins("*")를 사용하여 모든 도메인에서의 웹소켓 연결을 허용합니다.
        // withSockJS()를 사용하여 SockJS 폴백 옵션을 활성화합니다.
    }
}
