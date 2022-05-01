package org.drw.calamitaid.service;

import io.smallrye.graphql.api.Subscription;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.multi.processors.BroadcastProcessor;
import lombok.extern.slf4j.Slf4j;
import org.drw.calamitaid.modal.Incident;
import org.drw.calamitaid.modal.IncomingMessage;
import org.drw.calamitaid.modal.Location;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.reactive.messaging.*;
import org.locationtech.jts.io.ParseException;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
@Slf4j
public class IncidentService {

    BroadcastProcessor<Incident> processor = BroadcastProcessor.create();

    @Incoming("locations")
    public CompletionStage<Void> getLocations(Message<IncomingMessage> message)  {

        Incident incident = message.getPayload().getIncident();
        processor.onNext(incident);
        return message.ack();
    }

    public Multi<Incident> incidentCreated(){
        return  processor;
    }

}
