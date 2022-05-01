package org.drw.calamitaid.api;

import io.smallrye.graphql.api.Subscription;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.multi.processors.BroadcastProcessor;
import org.drw.calamitaid.modal.Incident;
import org.drw.calamitaid.service.IncidentService;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;

@GraphQLApi
public class IncidentResource {

    BroadcastProcessor<IncidentService> processor = BroadcastProcessor.create();

    @Inject
    private IncidentService incidentService;

    @Subscription
    @Description("Get incidents realtime")
    public Multi<Incident> incidentCreated(){
        return incidentService.incidentCreated();
    }

    @Query
    public Multi<Incident> getIncidents(){
        return incidentService.incidentCreated();
    }


}
