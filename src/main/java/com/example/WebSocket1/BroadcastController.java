package com.example.WebSocket1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BroadcastController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @PostMapping("/notification")
    public ResponseEntity sendBroadcastNotification(@RequestBody MessageDto messageDto){
        simpMessagingTemplate.convertAndSend("/topic/broadcast-message", messageDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
