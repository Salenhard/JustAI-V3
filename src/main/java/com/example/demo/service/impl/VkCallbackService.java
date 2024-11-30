package com.example.demo.service.impl;

import com.example.demo.dto.CallbackDto;
import com.example.demo.dto.MessageDto;
import com.example.demo.service.CallbackService;
import com.example.demo.service.MessageSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class VkCallbackService implements CallbackService {
    private final MessageSenderService<MessageDto> messageSenderService;
    private final QuoteService quoteService;

    @Override
    public String handleCallback(CallbackDto callbackDto) {
        switch (callbackDto.getType()) {
            case confirmation: {
                return "54b8fe34";
            }
            case message_new: {
                handleMessageNew(parseMessageNewCallback(callbackDto));
                return "ok";
            }
            default:
                throw new UnsupportedOperationException("Service supports only 'message_new' call");
        }
    }

    private static MessageDto parseMessageNewCallback(CallbackDto callbackDto) {
        Map<String, Object> message = (Map<String, Object>) callbackDto.getObject().get("message");
        return MessageDto.builder()
                .id(Long.parseLong(String.valueOf(message.get("id"))))
                .date(Long.parseLong(String.valueOf(message.get("date"))))
                .peerId(Long.parseLong(String.valueOf(message.get("peer_id"))))
                .fromId(Long.parseLong(String.valueOf(message.get("from_id"))))
                .text(String.valueOf(message.get("text")))
                .groupId(callbackDto.getGroupId())
                .build();
    }

    private void handleMessageNew(MessageDto messageNewCallback) {
        MessageDto dto = MessageDto.builder()
                .peerId(messageNewCallback.getPeerId())
                .text(quoteService.quote(messageNewCallback.getText()))
                .groupId(messageNewCallback.getGroupId())
                .build();
        messageSenderService.send(dto);
    }
}
