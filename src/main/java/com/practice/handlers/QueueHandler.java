package com.practice.handlers;

import com.practice.events.Event;
import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
public class QueueHandler implements Runnable {

    private ConcurrentLinkedQueue<Event> queue;

    public QueueHandler(Queue<Event> queue) {
        this.queue = (ConcurrentLinkedQueue<Event>) queue;
    }

    public Event getEvent() {
        return queue.poll();
    }

    @Override
    public void run() {
        log.info("QueueHandler started");
        while (true) {
            Event event = getEvent();
            if (event != null) {
                event.execute();
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.error("QueueHandler interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
