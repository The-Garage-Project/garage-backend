package com.garageproject.gp.services;

import com.garageproject.gp.dto.MailDTO;

import java.util.Properties;

public interface MailService {
    void sendMail(MailDTO mailDTO);
}
