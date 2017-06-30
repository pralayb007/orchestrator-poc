package org.pralayb.poc.command;

import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.pralayb.poc.configuration.FosPlusRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PanEUDependingOnApmsComposite implements RestrictionProviderCommand {

    @Autowired
    private FosPlusRequest request;
//
//    //@Value("#{request.getFosPlusRequest()['fnsku']?:null")
//    @Setter
//    private String fnsku;
//
//    //@Value("#{orchestrator.fosPlusRequest['iap']?:null}")
//    @Setter
//    private String iap;
//
//    //@Value("#{orchestrator.fosPlusRequest['iog']?:null}")
//    @Setter
//    private String iog;

    @Autowired
    @Qualifier("panEUGetBusinessConstraintGroupCommand")
    private RestrictionProviderCommand panEUGetBusinessRestrictionProviderCommand;

    @Autowired
    private RestrictionProviderCommand apmsGetIogFromIapCommand;


    @Override
    public String execute() {
        String result = "";
        if(StringUtils.isNotEmpty(request.getFosPlusRequest().get("iap"))) {
            result.concat(apmsGetIogFromIapCommand.execute());
        }
        return result.concat(panEUGetBusinessRestrictionProviderCommand.execute());
    }
}
