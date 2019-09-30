package ru.codeinside.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import ru.codeinside.websocket.model.Message;

import static java.util.Objects.requireNonNull;

/**
 * @author Alexey Dvoryaninov
 * @since 2019-09-28
 */
@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {

        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message message,
                           SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        requireNonNull(headerAccessor.getSessionAttributes(), "getSessionAttributes")
                .put("username", message.getSender());

        return message;
    }
}
