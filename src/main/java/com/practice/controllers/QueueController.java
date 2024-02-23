package com.practice.controllers;

import com.practice.domain.requests.EventRequest;
import com.practice.events.Event;
import com.practice.services.QueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class QueueController {

    private final QueueService queueService;

    @PostMapping("/addQueue")
    public ResponseEntity<String> addQueue(@RequestBody EventRequest eventRequest) {

        Event event = eventRequest.getEvent();
        if (event == null) {
            return ResponseEntity.badRequest().body("Event cannot be null.");
        }

        queueService.addEvent(event);
        return ResponseEntity.ok("Events successfully added to the queue.");
    }
}
