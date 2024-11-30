package com.example.demo.service.impl;

import com.example.demo.dto.MessageDto;
import com.example.demo.service.MessageSenderService;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VkMessageSenderService implements MessageSenderService<MessageDto> {
    private final GroupActor actor;
    private final VkApiClient vkApiClient;

    @Override
    public void send(MessageDto message) {
        try {
            vkApiClient.messages().sendDeprecated(actor)
                    .message(message.getText())
                    .peerId(message.getPeerId())
                    .randomId(message.hashCode())
                    .execute();
        } catch (ApiException | ClientException e) {
            throw new RuntimeException(e);
        }
    }
}
