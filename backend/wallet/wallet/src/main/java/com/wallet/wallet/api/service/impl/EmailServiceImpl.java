package com.wallet.wallet.api.service.impl;

import java.io.IOException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import com.wallet.wallet.api.service.IEmailService;
import com.wallet.wallet.domain.enums.EMessageCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements IEmailService {

    private final MessageSource messenger;
    private final SendGrid sendGrid;

    private final String ENDPOINT = "mail/send";

    @Value("${api.template.welcome.id}")
    private String TEMPLATE_ID;

    @Value("${app.email}")
    private String APP_EMAIL;

    @Override
    public void sendEmail(String toEmail, String username) {

        Email from = new Email(APP_EMAIL);
        Email to = new Email(toEmail);
        Mail mail = new Mail();
        Personalization personalization = new Personalization();
        personalization.addTo(to);
        personalization.addDynamicTemplateData("username", username);
        mail.setFrom(from);        
        mail.addPersonalization(personalization);
        mail.setTemplateId(TEMPLATE_ID);

        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint(ENDPOINT);
            request.setBody(mail.build());
            sendGrid.api(request);

        } catch (IOException e) {
            throw new RuntimeException(messenger.getMessage(EMessageCode.ERROR_SENDING_EMAIL.name(),
                    new Object[] { toEmail }, Locale.getDefault()));
        }
    }
}
