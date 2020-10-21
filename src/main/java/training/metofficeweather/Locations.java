package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Locations {
    @SerializedName(value="Location") // For Gson
    @JsonProperty(value="Location") // For ObjectMapper
    private Location[] locations;
}
