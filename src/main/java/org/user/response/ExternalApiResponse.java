package org.user.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExternalApiResponse {
    @JsonProperty("userId")
    private int userId;

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("completed")
    private boolean completed;
}

