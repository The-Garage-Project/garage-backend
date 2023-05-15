package com.garageproject.gp.pojos;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Component
@Validated
@ConfigurationProperties(prefix = "spring.mail")
public class MailConfig {
    @NotNull
    private String host;
    @NotNull
    private int port;
    @NotNull
    private String username;
    @NotNull
    private String password;
}