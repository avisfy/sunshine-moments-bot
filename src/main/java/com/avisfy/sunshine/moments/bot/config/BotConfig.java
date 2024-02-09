package com.avisfy.sunshine.moments.bot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BotConfig {
    @Getter
    @Setter
    @Value("${bot.token}")
    private String botToken;
    @Getter
    @Setter
    @Value("${bot.username}")
    private String botUsername;

    @Getter
    @Setter
    @Value("${bot.creatorId}")
    private Long creatorId;
}
