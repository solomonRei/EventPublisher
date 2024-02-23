package com.practice.controllers;

import com.practice.events.impl.MailEvent;
import com.practice.services.QueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class QueueController {

    private final QueueService queueService;

    @GetMapping("/addQueue")
    public ResponseEntity<String> addQueue() {
        for (int i = 0; i < 10; i++) {
            queueService.addEvent(new MailEvent("event" + i));
        }
        return ResponseEntity.ok("Events successfully added to the queue.");
    }
}
