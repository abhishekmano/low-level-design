package com.mano.Model;


import com.mano.Interface.ISubscriber;

import lombok.Data;

@Data
public class TopicSubscriber {
    private ISubscriber subscriber;
    public TopicSubscriber(ISubscriber subscriber){
        this.subscriber = subscriber;
    }
}
