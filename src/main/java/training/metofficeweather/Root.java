package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    @SerializedName(value="Locations") // For Gson
    @JsonProperty(value="Locations") // For ObjectMapper
    private Locations locations;
}
