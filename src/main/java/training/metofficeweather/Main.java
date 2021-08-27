package training.metofficeweather;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.glassfish.jersey.jackson.JacksonFeature;

public class Main {
    static final String siteListUrl =  "http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/sitelist?key=7581460d-7f90-4bd0-bacb-e72e36e3b557";
    static final Logger theLogger = LogManager.getLogger("Weather");
    public static void main(String[] args) {
        theLogger.info("Application Started");
        Client client = ClientBuilder.newClient();
        String siteList = client.target(siteListUrl)
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        theLogger.debug("siteList {}", siteList);
    }
}	
