package com.mano.Handler;

import com.mano.Model.Topic;
import com.mano.Model.TopicSubscriber;

import lombok.Getter;

@Getter
public class SubscriberWorker {
    private TopicSubscriber subscriber;
    private Topic topic;
    public SubscriberWorker(Topic topic , TopicSubscriber sub){
        this.subscriber = sub;
        this.topic = topic;
    }
    public void wakeUpIfNeeded(){

    }
    
}
