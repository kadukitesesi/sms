package com.kadukitesesi.sms.service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String phoneNumber;

    public void enviarMensagem(String para, String mensagem) {
        Twilio.init(accountSid, authToken);

        Message.creator(
                new PhoneNumber(para),
                new PhoneNumber(phoneNumber),
                mensagem
        ).create();
    }

}
