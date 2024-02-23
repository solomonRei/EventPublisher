package com.practice.services;

import com.practice.events.Event;
import com.practice.events.impl.ActionEvent;
import com.practice.events.impl.MailEvent;
import com.practice.handlers.impl.ActionHandler;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentLinkedQueue;

@Getter
@Setter
@Service
public class QueueService {

    private final ActionHandler actionHandler;

    @Autowired
    public QueueService(ActionHandler actionHandler) {
        this.actionHandler = actionHandler;
    }

    private ConcurrentLinkedQueue<Event> queue = new ConcurrentLinkedQueue<>();

    public void addEvent(Event event) {
        queue.add(event);
    }

}
