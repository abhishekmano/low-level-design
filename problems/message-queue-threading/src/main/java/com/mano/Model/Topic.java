package com.mano.Model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Topic {
    private String topicName;
    private String id;
    private final List<Message> messages;
    private final List<TopicSubscriber> subscribers;
    public Topic(String topicName ,String id){
        this.topicName = topicName;
        this.id = id;
        messages = new ArrayList<>();
        subscribers = new ArrayList<>();
    }
    public synchronized void addMessage(Message message){
        messages.add(message);
    }
    public void addSubscriber(TopicSubscriber subscriber){
        subscribers.add(subscriber);
    }

}
