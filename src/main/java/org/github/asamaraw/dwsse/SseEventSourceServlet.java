package org.github.asamaraw.dwsse;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.servlets.EventSource;
import org.eclipse.jetty.servlets.EventSourceServlet;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SseEventSourceServlet extends EventSourceServlet {

    private static final long serialVersionUID = -5947706431806660402L;

    @Override
    protected EventSource newEventSource(HttpServletRequest request) {
        log.info("SseEventSourceServlet");
        SseEventSource l = new SseEventSource();
        EventPublisher.addListener(l);
        return l;
    }

}
