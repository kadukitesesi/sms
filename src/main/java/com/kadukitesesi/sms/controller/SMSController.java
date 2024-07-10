package com.kadukitesesi.sms.controller;

import com.kadukitesesi.sms.model.SMSRequest;
import com.kadukitesesi.sms.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SMSController {

    private final TwilioService twilioService;

    @Autowired
    public SMSController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @PostMapping("/enviar-sms")
    public ResponseEntity<String> envioSMS(@RequestBody SMSRequest request) {
        try {
        twilioService.enviarMensagem(request.getPara(), request.getMensagem());
        return new ResponseEntity<>("SMS enviado com sucesso", HttpStatus.OK);
    } catch (Exception e) {
         return new ResponseEntity<>("Erro ao enviar mensagem: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
