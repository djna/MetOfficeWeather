package training.metofficeweather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class Main {

    public static final String URL = "http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/sitelist?key=PUT_YOUR_API_KEY_HERE";

    public static void main(String args[]) throws IOException {
        System.out.println("Reading data as a string");
        Client client = ClientBuilder.newClient();
        String json = client.target(URL)
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        System.out.println("Object mapper method");
        Root root = getRootObjectMapper(json);
        outputResults(root);

        System.out.println("Gson method");
        root = getRootGson(json);
        outputResults(root);

        System.out.println("Glassfish Jersey method (Reading data directly as a Root object)");
        root = getRootGlassfish();
        outputResults(root);
    }

    private static Root getRootObjectMapper(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Root.class);
    }

    private static Root getRootGson(String json) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, Root.class);
    }

    private static Root getRootGlassfish() {
        Client client = ClientBuilder.newClient();
        return client.target(URL)
                .request(MediaType.TEXT_PLAIN)
                .get(Root.class);
    }

    private static void outputResults(Root root) {
        Locations locations = root.getLocations();
        Location[] locationsLocations = locations.getLocations();
        System.out.println("Number of items found: " + locationsLocations.length);
    }
}
