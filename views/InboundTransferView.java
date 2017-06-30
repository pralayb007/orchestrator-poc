package org.pralayb.poc.views;

import lombok.Getter;
import lombok.Setter;
import org.pralayb.poc.command.PanEUDependingOnApmsComposite;
import org.pralayb.poc.command.RestrictionProviderCommand;
import org.pralayb.poc.configuration.FosPlusRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Analogous to existing FOS view
//Contains details around FOS+ based dependencies
//In this case, it just executes PanEU dependencies
@Component
public class InboundTransferView implements Views {

    private List<RestrictionProviderCommand> dependencies;

    @Autowired
    private FosPlusRequest fosPlusRequest;

    /*
    If you did not have a transitive dependency, you could have just loaded these command objects directly
    These are just here for demo purposes.
    @Autowired
    private RestrictionProviderCommand apmsRestrictionProviderCommand;

    @Autowired
    private RestrictionProviderCommand panEUGetBusinessRestrictionProviderCommand;
    */


    //This is a composite object that deals with the cases of a dependency needing to call another dependency
    @Autowired
    @Qualifier("panEUDependingOnApmsComposite")
    private RestrictionProviderCommand panEUDependingOnApmsComposite;

    @Override
    public String getDataFromViewDependencies() {
        this.panEUDependingOnApmsComposite.execute();
        //return this.dependencies.stream().map(x ->x.execute()).collect(Collectors.joining());
//        String result ="";
//        for (RestrictionProviderCommand res: this.dependencies) {
//            System.out.println(res.execute());
//            result.concat(res.execute());
//        }
        return this.panEUDependingOnApmsComposite.execute();
    }
}
