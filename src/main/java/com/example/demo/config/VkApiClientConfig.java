package com.example.demo.config;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class VkApiClientConfig {
    @Value("${value.vk.key}")
    private String VK_KEY;
    @Value("${value.vk.group_id}")
    private Long GROUP_ID;

    @Bean
    public VkApiClient vkApiClient() {
        TransportClient transportClient = new HttpTransportClient();
        return new VkApiClient(transportClient);
    }

    @Bean
    public GroupActor actor() {
        return new GroupActor(GROUP_ID, VK_KEY);
    }

}
