package com.michaelloi.common.services;

import com.google.gson.Gson;
import com.michaelloi.common.constants.LoggerTypes;
import com.michaelloi.common.models.objects.Error;
import com.michaelloi.common.models.objects.ErrorParser;
import com.michaelloi.common.models.objects.LogFormat;
import com.michaelloi.common.models.objects.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoggerService {
    private final Logger logger = LoggerFactory.getLogger(LoggerService.class);
    private final Gson gson = new Gson();

    private void writeLog(LogFormat logFormat){
        logger.error(gson.toJson(logFormat));
    }

    public String writeRequest(Message message){
        String uuid = message.getSession().getUuid().isEmpty()
            ? UUID.randomUUID().toString()
            : message.getSession().getUuid();
        message.getSession().setUuid(uuid);

        LogFormat logFormat = new LogFormat();
        logFormat.setEvent(LoggerTypes.request.toUpperCase());
        logFormat.setUuid(uuid);
        logFormat.setPath(message.getSession().getPath());
        logFormat.setService(message.getSession().getService());
        logFormat.setMessage(message);

        writeLog(logFormat);
        return uuid;
    }

    public void writeResponse(Message message){
        LogFormat logFormat = new LogFormat();
        logFormat.setEvent(LoggerTypes.response.toUpperCase());
        logFormat.setUuid(message.getSession().getUuid());
        logFormat.setPath(message.getSession().getPath());
        logFormat.setService(message.getSession().getService());
        logFormat.setMessage(message);

        writeLog(logFormat);
    }

    public void writeException(Error error){
        LogFormat logFormat = new LogFormat();
        logFormat.setEvent(LoggerTypes.exception.toUpperCase());
        logFormat.setUuid(error.getSession().getUuid());
        logFormat.setPath(error.getSession().getPath());
        logFormat.setService(error.getSession().getService());

        if(error.getError() instanceof Throwable){
            logFormat.setMessage(ErrorParser.convertToJson((Throwable) error.getError()));
        }else{
            logFormat.setMessage(error);
        }
        writeLog(logFormat);
    }
}
