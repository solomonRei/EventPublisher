package com.practice.events.impl;

import com.practice.events.Event;

public class MailEvent implements Event {

    private final String message;

    public MailEvent(String message) {
        this.message = message;
    }

    @Override
    public void execute() {
        System.out.println("Mail event executed" + message);
    }
}
