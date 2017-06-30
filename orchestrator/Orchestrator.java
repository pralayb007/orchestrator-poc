package org.pralayb.poc.orchestrator;


import lombok.Setter;
import org.pralayb.poc.configuration.FosPlusRequest;
import org.pralayb.poc.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

//Simulates orchestrator that simply takes in all params that FOS passes it, and uses the view to pull up right set
//dependencies.

@Component
public class Orchestrator {

    @Autowired
    private Views view;

//   @Autowired
//   private FosPlusRequest

    public String executeView () {
        return this.view.getDataFromViewDependencies();
    }
}
