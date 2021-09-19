package com.black.kafkaservice.controller;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageService
{
    private final Map<String, List<MessageRequest>> messages = new HashMap<>();

    public void addMessage( String topic, MessageRequest data )
    {
        messages.computeIfAbsent( topic, ( t ) -> new ArrayList<>() )
                .add( data );
    }

    public List<MessageRequest> getMessages( String topic )
    {
        return messages.getOrDefault( topic, Collections.emptyList() );
    }

    public void clear( String topic )
    {
        messages.get( topic ).clear();
    }
}
