package org.pralayb.poc.configuration;

import com.sun.tools.corba.se.idl.constExpr.Or;
import org.pralayb.poc.command.PanEUDependingOnApmsComposite;
import org.pralayb.poc.command.PanEUGetBusinessConstraintGroupCommand;
import org.pralayb.poc.dependencies.MCIIServiceClient;
import org.pralayb.poc.orchestrator.Orchestrator;
import org.pralayb.poc.runners.FOS;
import org.pralayb.poc.command.APMSGetIogFromIAPCommand;
import org.pralayb.poc.command.RestrictionProviderCommand;
import org.pralayb.poc.dependencies.APMSClient;
import org.pralayb.poc.views.InboundTransferView;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;

@Configuration
public class FosPlusDIConfiguration {

    //Fake FOS Service
    @Bean
    @DependsOn("orchestrator")
    public FOS fosService() {
        return new FOS();
    }

    @Bean
    @DependsOn({"fosPlusRequest", "view"})
    public Orchestrator orchestrator(){
        return new Orchestrator();
    }

    @Bean
    @Scope("prototype")
    @DependsOn({"fosPlusRequest", "panEUDependingOnApmsComposite"})
    public InboundTransferView view() {
        //InboundTransferView inboundTransferView = new InboundTransferView();
        return new InboundTransferView();
    }

    @Bean("panEUDependingOnApmsComposite")
    @DependsOn({"fosPlusRequest"})
    public RestrictionProviderCommand panEUDependingOnApmsComposite() {
        return new PanEUDependingOnApmsComposite();
    }

    @Bean
    public APMSClient apmsClient() {
        return new APMSClient();
    }

    @Bean
    @DependsOn({"fosPlusRequest"})
    public RestrictionProviderCommand apmsGetIogFromIapCommand(){
        APMSGetIogFromIAPCommand apmsGetIogFromIAPCommand = new APMSGetIogFromIAPCommand();
        apmsGetIogFromIAPCommand.setApmsClient(apmsClient());
        return apmsGetIogFromIAPCommand;
    }

    @Bean

    public MCIIServiceClient mciiServiceClient() {
        return new MCIIServiceClient();
    }

    @Bean
    @DependsOn({"fosPlusRequest"})
    public RestrictionProviderCommand panEUGetBusinessConstraintGroupCommand() {
        PanEUGetBusinessConstraintGroupCommand panEUGetBusinessConstraintGroupCommand = new PanEUGetBusinessConstraintGroupCommand();
        panEUGetBusinessConstraintGroupCommand.setMciiServiceClient(mciiServiceClient());
        return panEUGetBusinessConstraintGroupCommand;
    }

    @Bean("fosPlusRequest")
    public FosPlusRequest fosPlusRequest() {
        return new FosPlusRequest();
    }

}
