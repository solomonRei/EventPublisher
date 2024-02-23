package com.practice.events;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.practice.events.impl.ActionEvent;
import com.practice.events.impl.MailEvent;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ActionEvent.class, name = "actionEvent"),
        @JsonSubTypes.Type(value = MailEvent.class, name = "mailEvent")
})
public interface Event {

}
