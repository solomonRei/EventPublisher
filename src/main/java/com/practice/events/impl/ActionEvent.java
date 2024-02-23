package com.practice.events.impl;

import com.practice.events.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionEvent implements Event {

    private String message;

    private String action;

}
