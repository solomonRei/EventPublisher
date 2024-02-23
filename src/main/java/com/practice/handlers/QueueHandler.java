package com.practice.handlers;

import com.practice.events.Event;
import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
public class QueueHandler implements Runnable {

    private ConcurrentLinkedQueue<Event> queue;

    private HandlerFactory handlerFactory;

    public QueueHandler(Queue<Event> queue, HandlerFactory handlerFactory) {
        this.queue = (ConcurrentLinkedQueue<Event>) queue;
        this.handlerFactory = handlerFactory;
    }

    public Event getEvent() {
        return queue.poll();
    }

    private void callHandler(Event event) {
        Handler handler = handlerFactory.getHandler(event);
        handler.handle(event);
    }

    @Override
    public void run() {
        log.info("QueueHandler started");
        while (true) {
            Event event = getEvent();
            if (event != null) {
                callHandler(event);
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
