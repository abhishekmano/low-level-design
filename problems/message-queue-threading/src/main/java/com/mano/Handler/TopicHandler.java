package com.mano.Handler;

import java.util.HashMap;

import com.mano.Model.Topic;
import com.mano.Model.TopicSubscriber;

import lombok.Data;

@Data
public class TopicHandler {
    public Topic topic;    
    private HashMap<String,SubscriberWorker> subscriberWorkers;
    public TopicHandler(Topic topic){
        this.topic = topic;
        subscriberWorkers = new HashMap<>();
    }
    public void publish(){
        for(TopicSubscriber topicSubscriber : topic.getSubscribers()){
            startSubscriberWorker(topicSubscriber);
        }
    }
    public void startSubscriberWorker(TopicSubscriber subscriber){  
        String subId = subscriber.getSubscriber().getId();
        if(!subscriberWorkers.containsKey(subId)){
            SubscriberWorker subscriberWorker = new SubscriberWorker(topic, subscriber);
            subscriberWorkers.put(subId , subscriberWorker);
        }
        SubscriberWorker worker = subscriberWorkers.get(subId);
        worker.wakeUpIfNeeded();
    }
}
