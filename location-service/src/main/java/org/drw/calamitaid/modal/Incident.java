package org.drw.calamitaid.modal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@JsonIgnoreProperties({"schema", "before", "created_by", "created_on"})
@Data
public class Incident {

    @JsonAlias({ "incd_id" })
    private int incidentId;
    @JsonAlias({ "incd_name" })
    private String incidentName;

    private Location incidentLocation;

    @JsonProperty("incd_location")
    private void unpackNested(String location) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        this.incidentLocation =  objectMapper.readValue( location, Location.class);
    }

}
