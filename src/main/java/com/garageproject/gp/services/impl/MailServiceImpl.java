package com.garageproject.gp.services.impl;

import com.garageproject.gp.dto.MailDTO;
import com.garageproject.gp.pojos.MailConfig;
import com.garageproject.gp.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Date;
import java.util.Properties;

import static java.nio.file.Files.readAllBytes;
import static javax.mail.Transport.send;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    @Value("${spring.mail.sender}")
    private String sender;
    private final MailConfig mailConfig;
    @Override
    public void sendMail(MailDTO mailDTO) {
        Properties properties = getProperties();
        Session session = Session.getInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(sender);
            message.setRecipients(Message.RecipientType.TO, mailDTO.getReceiver());
            message.setSubject(mailDTO.getSubject());
            message.setText(mailDTO.getText());
            message.setSentDate(new Date());

            send(message);
        }catch (Exception exception) {
            System.out.println("Sending Email failed, error : " + exception.getMessage());
        }
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", mailConfig.getHost());
        properties.put("mail.smtp.port", mailConfig.getPort());
        properties.put("mail.user", mailConfig.getPort());
        properties.put("mail.password", mailConfig.getPort());

        return properties;
    }
}
