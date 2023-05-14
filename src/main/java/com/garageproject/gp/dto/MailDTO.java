package com.garageproject.gp.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MailDTO {
    private String receiver;
    private String subject;
    private String text;
}
