package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonPropertyOrder(alphabetic = true)
public class MessageDto {
    private Long date;
    @JsonProperty("from_id")
    private Long fromId;
    private Long id;
    private Long version;
    private Integer out;
    private Boolean important;
    @JsonProperty("is_hidden")
    private Boolean isHidden;
    @JsonProperty("conversation_message_id")
    private Boolean conversationMessageId;
    private String text;
    @JsonProperty("group_Id")
    private Long groupId;
    @JsonProperty("peer_id")
    private Long peerId;
    @JsonProperty("random_id")
    private Integer randomId;
}
