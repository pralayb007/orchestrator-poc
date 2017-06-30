package org.pralayb.poc.dependencies;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.pralayb.poc.views.schema.PanEUPojo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MCIIServiceClient {

    public PanEUPojo getBusinessConstraintGroups(String fnsku, String iog) throws IOException {
        String mciis = readFile("/Users/pralayb/workplace/personal/Spring workfiles/spring-modules/spring-kevin-doodles/src/main/resources/PanEU4Schema.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(mciis, PanEUPojo.class);
    }

    private String readFile(String path) throws IOException
    {
        byte[] encoded = new byte[0];
            encoded = Files.readAllBytes(Paths.get(path));
        return new String(Files.readAllBytes(Paths.get(path)), Charset.defaultCharset());
    }

    public static void main(String[] args) throws IOException {
        MCIIServiceClient mciiServiceClient = new MCIIServiceClient();
        mciiServiceClient.getBusinessConstraintGroups("a", "b");
    }
}
