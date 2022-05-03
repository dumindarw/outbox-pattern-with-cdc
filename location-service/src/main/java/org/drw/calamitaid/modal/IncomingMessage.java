package org.drw.calamitaid.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import javax.json.JsonObject;

@Data
public class IncomingMessage {

    @JsonIgnore
    private JsonObject schema;

    private Incident incident;

    @JsonProperty("payload")
    private void unpackNested(JsonNode payload) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        this.incident =  objectMapper.treeToValue( payload.get("after"), Incident.class);
    }

}
