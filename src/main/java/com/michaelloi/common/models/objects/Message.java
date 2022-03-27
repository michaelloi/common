package com.michaelloi.common.models.objects;

import com.michaelloi.common.constants.DefaultValues;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Session session;
    private Object message = DefaultValues.emptyString;

    public Message(Session session) {
        this.session = session;
    }
}
