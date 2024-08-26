package com.mano.Model;


import java.util.concurrent.atomic.AtomicInteger;

import com.mano.Interface.ISubscriber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TopicSubscriber {
    private ISubscriber subscriber;
    private AtomicInteger offset;
    public TopicSubscriber(ISubscriber subscriber){
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }
}
