package com.michaelloi.common.services;

import com.michaelloi.common.constants.DateFormats;
import com.michaelloi.common.constants.DefaultValues;
import com.michaelloi.common.constants.Lengths;
import com.michaelloi.common.models.objects.Session;
import com.michaelloi.common.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SessionService {
    @Autowired
    SessionRepository sessionRepository;

    public String generateSessionId() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormats.id);
        String currentDate = simpleDateFormat.format(new Date());
        String uuid = request.getSession().getId() + currentDate;

        if (uuid.length() > Lengths.sessionId) {
            uuid.substring(DefaultValues.emptyInt, Lengths.sessionId);
        }
        return uuid;
    }

    public Session getSessionId(String sessionId) {
        Session session = new Session();
        session.setSessionId(sessionRepository.getSessionIdData(sessionId));
        return session;
    }
}
