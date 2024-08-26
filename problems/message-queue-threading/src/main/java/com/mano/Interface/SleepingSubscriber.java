package com.mano.Interface;

import com.mano.Model.Message;

public class SleepingSubscriber implements ISubscriber {
    public String id;
    private final int sleepTime;
    public SleepingSubscriber(String id , int sleepTime){
        this.id = id;
        this.sleepTime = sleepTime;
    }
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void consume(Message message) throws InterruptedException {
        System.out.println("Subscriber: "  + id + " started consuming " + message.getMessage());
        Thread.sleep(sleepTime);
        System.out.println("Subscriber: "  + id + " consumed " + message.getMessage());
    }
    
}
