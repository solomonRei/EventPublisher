package com.practice.handlers.impl;

import com.practice.events.Event;
import com.practice.events.impl.ActionEvent;
import com.practice.handlers.Handler;
import com.practice.model.EventModel;
import com.practice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActionHandler implements Handler {

    private final EventRepository eventRepository;

    @Autowired
    public ActionHandler(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void handle(Event event) {
        EventModel eventModel = fromEventToModel((ActionEvent) event);
        eventRepository.save(eventModel);
    }

    private EventModel fromEventToModel(ActionEvent event) {
        var s = new StringBuilder();
        s.append("{");
        s.append("message:").append(event.getMessage());
        s.append("}");
        EventModel model = new EventModel();
        model.setData(String.valueOf(s));
        model.setType("ActionEvent");
        return model;

    }
}
