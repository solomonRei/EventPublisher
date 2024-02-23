package com.practice.services;

import com.practice.events.Event;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentLinkedQueue;

@Getter
@Setter
@Service
public class QueueService {

    private volatile ConcurrentLinkedQueue<Event> queue = new ConcurrentLinkedQueue<>();

    public void addEvent(Event event) {
        queue.add(event);
    }

}
