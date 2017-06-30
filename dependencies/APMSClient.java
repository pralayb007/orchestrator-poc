package org.pralayb.poc.dependencies;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

//Simulates a fake APMS client

@Component
public class APMSClient {

    public String getIogFromIAP(String anyIAP) {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "iog_123456";
    }

    public String getIoglFromIog (String anyIOG) {
        return "fooBarBaz";
    }
}
