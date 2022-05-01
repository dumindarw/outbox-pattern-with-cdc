package org.drw.calamitaid;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import org.drw.calamitaid.modal.IncomingMessage;

public class IncidentDeserializer extends ObjectMapperDeserializer<IncomingMessage> {
    public IncidentDeserializer() {
        super(IncomingMessage.class);
    }
}
