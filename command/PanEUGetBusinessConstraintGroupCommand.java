package org.pralayb.poc.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import lombok.Setter;
import org.pralayb.poc.configuration.FosPlusRequest;
import org.pralayb.poc.dependencies.MCIIServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PanEUGetBusinessConstraintGroupCommand implements RestrictionProviderCommand {

//    @Value("#{fosPlusRequest.getFosPlusRequest()['fnsku']?:null}")
//    private String fnsku;
//
//    @Value("#{fosPlusRequest.getFosPlusRequest().get['iog']?:null}")
//    private String iog;

    @Autowired
    private FosPlusRequest fosPlusRequest;

    @Setter
    private MCIIServiceClient mciiServiceClient;

    @Override
    public String execute() {
        Preconditions.checkNotNull(fosPlusRequest.getFosPlusRequest().get("fnsku"));
        Preconditions.checkNotNull(fosPlusRequest.getFosPlusRequest().get("iog"));
        try {
            return new ObjectMapper().writeValueAsString(
                    mciiServiceClient.getBusinessConstraintGroups(fosPlusRequest.getFosPlusRequest().get("fnsku"),
                            fosPlusRequest.getFosPlusRequest().get("iog")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
