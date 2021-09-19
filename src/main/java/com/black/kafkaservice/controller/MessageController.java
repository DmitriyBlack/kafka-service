package com.black.kafkaservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping( "/message" )
public class MessageController
{
    private final MessageService messageService;

    @PostMapping
    public void send( @NotEmpty @RequestParam( value = "topic" ) String topic, @Valid @RequestBody MessageRequest message )
    {
        messageService.addMessage( topic, message );
    }

    @GetMapping
    public List<MessageRequest> readAll( @NotEmpty @RequestParam( value = "topic" ) String topic )
    {
        return messageService.getMessages( topic );
    }

    @DeleteMapping
    public void clear( @NotEmpty @RequestParam( value = "topic" ) String topic )
    {
        messageService.clear( topic );
    }
}
