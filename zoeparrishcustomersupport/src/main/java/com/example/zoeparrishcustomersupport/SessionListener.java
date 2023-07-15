package com.example.zoeparrishcustomersupport;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionIdListener;
import jakarta.servlet.http.HttpSessionListener;


@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionIdListener {

    @Override
    public void sessionIdChanged(HttpSessionEvent se, String oldId) {
        SessionListUtility.updateSessionId(se.getSession(),oldId);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        SessionListUtility.addSession(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        SessionListUtility.removeSession(se.getSession());
    }
}
