package com.qnfzksla.projectboardadmin.controller;

import com.qnfzksla.projectboardadmin.dto.websocket.WebSocketMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/chat")
    public WebSocketMessage chat(WebSocketMessage message, Principal principal) throws  Exception{
        Thread.sleep(1000);

        return WebSocketMessage.of("안녕하세요 chat 봇이에요 " + principal.getName() + "! " + message.content() + "라고 하셨나요?");
    }
}
