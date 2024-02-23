package com.practice.events.impl;

import com.practice.events.Event;

public class ActionEvent implements Event {

    private final String message;

    public ActionEvent(String message) {
        this.message = message;
    }

    @Override
    public void execute() {
        System.out.println("Action event executed" + message);
    }
}
