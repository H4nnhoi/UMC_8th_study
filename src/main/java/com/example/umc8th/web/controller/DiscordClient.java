package com.example.umc8th.web.controller;


import com.example.umc8th.config.DiscordFeignConfig;
import com.example.umc8th.web.dto.discord.DiscordMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "discord-client",
        url = "${discord.webhook.url}",
        configuration = DiscordFeignConfig.class)
public interface DiscordClient {

    @PostMapping
    void sendAlarm(@RequestBody DiscordMessage message);

}
