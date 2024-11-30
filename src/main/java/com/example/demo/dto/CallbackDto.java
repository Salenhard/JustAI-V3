package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallbackDto {
    @JsonProperty(value = "type")
    private CallbackType type;
    @JsonProperty(value = "group_id")
    private Long groupId;
    private Map<String, Object> object;
}
