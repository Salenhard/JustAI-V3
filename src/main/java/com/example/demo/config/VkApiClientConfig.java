package com.example.demo.config;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class VkApiClientConfig {
    private static final String VK_KEY = "vk1.a.VN39_IQqnVdIqqqjfTAc2AogAGfBZVt9OY-0L2PRv1NpoelMkw0g7yfmzaDqb39XF1FdFfDTNr1Pxq-UCCZX3vHTwghwXl1tDr0PuNv6OHIQQyaZtjEDOmJjz-wgdU5bXw6I4P_Iz8ynzqIzUMq0sZFy-3i-pHkjN-I3ePZx3qyAvqL-BIdrf9Z5JLN_iYPPEfaj24z1yL9mv7BNMvlqTQ";
    private static final Long GROUP_ID = 228482978L;

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
