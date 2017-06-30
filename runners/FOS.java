package org.pralayb.poc.runners;

import com.google.common.collect.Maps;
import lombok.Setter;
import org.pralayb.poc.configuration.FosPlusRequest;
import org.pralayb.poc.orchestrator.Orchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//Simulates the FOS service with one activity getFeasibleGraph

@Component
public class FOS {

    @Autowired
    private Orchestrator orchestrator;

    @Autowired
    private FosPlusRequest request;

    //This method simulates calling Orchestrator
    public String getFeasibleGraph(String fnsku, String iap, String viewName) {
        HashMap<String, String> fosPlusRequest = prepareFosPlusRequest(fnsku, iap, viewName);
        request.setFosPlusRequest(fosPlusRequest);
        return orchestrator.executeView();
    }

    private HashMap<String, String> prepareFosPlusRequest(String fnsku, String iap, String viewName) {
        HashMap<String, String> fosPlusRequest = Maps.newHashMap();
        fosPlusRequest.putIfAbsent("fnsku", fnsku);
        fosPlusRequest.putIfAbsent("iap", iap);
        fosPlusRequest.putIfAbsent("viewName", viewName);
        return fosPlusRequest;
    }
}
