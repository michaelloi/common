package com.michaelloi.common.models.requests;

import com.michaelloi.common.models.objects.Session;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseRequest<T> {
    private Session session;
    private T request;
}
