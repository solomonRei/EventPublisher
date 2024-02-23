package com.practice.handlers;

import com.practice.events.Event;
import com.practice.events.impl.ActionEvent;
import com.practice.events.impl.MailEvent;
import com.practice.handlers.impl.ActionHandler;
import com.practice.handlers.impl.MailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HandlerFactory {

    private final ActionHandler actionHandler;

    private final MailHandler mailHandler;

    @Autowired
    public HandlerFactory(ActionHandler actionHandler, MailHandler mailHandler) {
        this.actionHandler = actionHandler;
        this.mailHandler = mailHandler;
    }

    public Handler getHandler(Event event) {
        if (event instanceof ActionEvent) {
            return actionHandler;
        } else if (event instanceof MailEvent) {
            return mailHandler;
        }
        throw new IllegalArgumentException("Unknown event type");
    }
}