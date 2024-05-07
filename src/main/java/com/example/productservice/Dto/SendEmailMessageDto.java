package com.example.productservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SendEmailMessageDto {
        private String from;
        private String to;
        private String subject;
        private String body;
    }

