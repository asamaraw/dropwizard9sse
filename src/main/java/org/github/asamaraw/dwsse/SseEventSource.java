package org.github.asamaraw.dwsse;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import org.eclipse.jetty.servlets.EventSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SseEventSource implements EventSource {

    private Emitter emitter;
    private String id;

    public SseEventSource() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public void onOpen(Emitter emitter) throws IOException {
        log.info("onOpen");
        this.emitter = emitter;
    }

    @Override
    public void onClose() {
        log.info("onClose");
        EventPublisher.removeListener(this);
    }

    public void emitEvent(String dataToSend) throws IOException {
        log.info("emitEvent");
        this.emitter.data(dataToSend);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SseEventSource) {
            SseEventSource that = (SseEventSource)obj;
            return Objects.equals(this.id, that.id);
        }
        return false;
    }

}
