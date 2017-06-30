package org.pralayb.poc.command;

import lombok.Setter;
import org.pralayb.poc.configuration.FosPlusRequest;
import org.pralayb.poc.dependencies.APMSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class APMSGetIogFromIAPCommand implements RestrictionProviderCommand{

//    @Value("#{fosPlusRequest['iap']}")
//    private String iap;

    @Autowired
    private FosPlusRequest fosPlusRequest;

    @Setter
    private APMSClient apmsClient;

    @Override
    public String execute() {
        String iog = apmsClient.getIogFromIAP(fosPlusRequest.getFosPlusRequest().get("iap"));
        fosPlusRequest.getFosPlusRequest().putIfAbsent("iog",iog);
        return iog;

    }
}
