package com.novice.dev.simplewebstocket.controller;

import com.novice.dev.simplewebstocket.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;

	@MessageMapping("/sendNotification")
	@SendTo("/topic/notifications")
	public String send(String message) {
		// Send the notification to the "/topic/notifications" channel
		System.out.println("Controller receive :: " + message);
//		simpMessagingTemplate.convertAndSend("/topic/notifications", message);
		return message;
	}

}
