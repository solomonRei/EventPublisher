package com.practice.handlers.impl;

import com.google.gson.Gson;
import com.practice.events.Event;
import com.practice.events.impl.MailEvent;
import com.practice.handlers.Handler;
import com.practice.model.EventModel;
import com.practice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailHandler implements Handler {

    private final EventRepository eventRepository;

    private Gson gson = new Gson();

    @Autowired
    public MailHandler(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void handle(Event event) {
        MailEvent mailEvent = (MailEvent) event;
        EventModel eventModel = fromEventToModel(mailEvent);
        eventRepository.save(eventModel);
    }

    private EventModel fromEventToModel(MailEvent event) {
        String jsonData = gson.toJson(event);

        EventModel eventModel = new EventModel();
        eventModel.setType("MailEvent");
        eventModel.setData(jsonData);
        return eventModel;
    }
}
