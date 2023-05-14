package com.garageproject.gp.controllers;

import com.garageproject.gp.dto.MailDTO;
import com.garageproject.gp.services.MailService;
import com.garageproject.gp.services.impl.MailServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @PostMapping("/send-mail")
    void sendMail(@RequestBody MailDTO mailDTO) {
        mailService.sendMail(mailDTO);
    }
}
