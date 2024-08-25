package com.mano.Interface;

import com.mano.Model.Message;

public interface ISubscriber {
   public String getId();
   void consume(Message message) throws InterruptedException;
}
