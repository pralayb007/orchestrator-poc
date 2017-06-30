package org.pralayb.poc.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FosPlusRequest {
    @Setter @Getter
    private Map<String, String> fosPlusRequest;
}
