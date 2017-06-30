package org.pralayb.poc.command;

import org.springframework.stereotype.Component;

//This is the command pattern interface
public interface RestrictionProviderCommand {

    //The string that will be returned will be a JSON - simulates ION
    String execute();

}
