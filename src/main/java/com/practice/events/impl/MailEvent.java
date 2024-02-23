package com.practice.events.impl;

import com.practice.events.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailEvent implements Event {

    private String message;

    private String subject;

    private String to;

    private String from;

}
