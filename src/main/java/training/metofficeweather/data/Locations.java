package training.metofficeweather.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;


public class Locations {
    @JsonProperty(value="Location")
    Location[] locations;

    @Override
    public String toString() {
        return "Locations{" +
                "locations=" + locations.length +
                '}';
    }
}
