package com.mano.Interface;

import java.util.HashMap;
import java.util.UUID;

import com.mano.Handler.TopicHandler;
import com.mano.Model.Message;
import com.mano.Model.Topic;
import com.mano.Model.TopicSubscriber;

public class Queue {
    private final HashMap<String,TopicHandler> processor;
    public Queue(){
        processor = new HashMap<>();
    }
    public Topic createTopic(String topicName){
        final Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler handler = new TopicHandler(topic);
        processor.put(topic.getId(),handler);
        System.out.println("Created Topic : " + topicName);
        return topic;
    }
    public void subscribe(ISubscriber subscriber , Topic topic){
        final TopicSubscriber sub = new TopicSubscriber(subscriber);
        topic.addSubscriber(sub);
        System.out.println("Subscriber : " + subscriber.getId() + " Subscribed to " + topic.getTopicName() );

    }
    public void publish(Topic topic , Message message){

    }

}
