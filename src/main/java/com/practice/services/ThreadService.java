package com.practice.services;

import com.practice.handlers.HandlerFactory;
import com.practice.handlers.QueueHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ThreadService {

    private final QueueService queueService;

    private final HandlerFactory handlerFactory;

    public void startManager(int nbOfThreads) {

        List<Thread> threads = new ArrayList<>(nbOfThreads);

        var queue = queueService.getQueue();

        for (int i = 0; i < nbOfThreads; i++) {
            threads.add(new Thread(new QueueHandler(queue, handlerFactory), "#" + (i + 1)));
            threads.get(i).start();
        }


        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error("Error while joining threads", e);
            }
        }
    }
}
