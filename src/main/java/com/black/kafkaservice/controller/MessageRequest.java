package com.black.kafkaservice.controller;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MessageRequest
{
    @NotEmpty
    private String data;
}
