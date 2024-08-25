package com.mano.Handler;

import com.mano.Model.Message;
import com.mano.Model.Topic;
import com.mano.Model.TopicSubscriber;

import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public class SubscriberWorker implements Runnable {
    private TopicSubscriber topicSubscriber;
    private Topic topic;
    public SubscriberWorker(Topic topic , TopicSubscriber sub){
        this.topicSubscriber = sub;
        this.topic = topic;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized(topicSubscriber){
            do{
                int offset = topicSubscriber.getOffset().get();
                while(offset >= topic.getMessages().size()){
                    topicSubscriber.wait();
                }
                Message message = topic.getMessages().get(offset);
                topicSubscriber.getSubscriber().consume(message);

                topicSubscriber.getOffset().compareAndSet(offset, offset + 1);

            }
            while(true);
        }
    }
    public  synchronized void wakeUpIfNeeded(){
        synchronized(topicSubscriber){
            topicSubscriber.notify();
        }
    }

    
}
