package model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Builder @Jacksonized
@ToString
@EqualsAndHashCode
public class Berry {
    @JsonProperty("id")
    private int id;
    @JsonProperty("title")
    private String name;
}
