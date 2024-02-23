package com.practice.domain.requests;

import com.practice.events.Event;
import lombok.Data;

@Data
public class EventRequest {

    private Event event;
}
