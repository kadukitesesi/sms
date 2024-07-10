package com.kadukitesesi.sms.model;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SMSRequest {

    private String para;
    private String mensagem;
}
