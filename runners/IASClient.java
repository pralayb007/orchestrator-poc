package org.pralayb.poc.runners;

import org.pralayb.poc.configuration.FosPlusDIConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//This simulates the IASClient that is trying to make a call into FOS service's getFeasibleGraphAPI
public class IASClient {

    public static void main(String[] args) {
        //Fire up the container
        ApplicationContext context = new AnnotationConfigApplicationContext(FosPlusDIConfiguration.class);

        //FOS fosServiceClient = context.getBean("fosService", FOS.class);
        FOS fosServiceClient = context.getBean(FOS.class);
        System.out.println(fosServiceClient.getFeasibleGraph("fnsku001", "iap_102030", "inboundTransferView"));

    }

}
