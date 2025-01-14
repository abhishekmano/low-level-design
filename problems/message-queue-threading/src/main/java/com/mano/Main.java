package com.mano;

import com.mano.Interface.Queue;
import com.mano.Interface.SleepingSubscriber;
import com.mano.Model.Message;
import com.mano.Model.Topic;

//Taken from Udit Agarwal for Learning 
//If you want actual code please visit his youtube channel
public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Queue queue = new Queue();
        final Topic topic1 = queue.createTopic("t1");
        final Topic topic2 = queue.createTopic("t2");
        final SleepingSubscriber sub1 = new SleepingSubscriber("sub1", 10000);
        final SleepingSubscriber sub2 = new SleepingSubscriber("sub2", 10000);
        final SleepingSubscriber  sub3 = new SleepingSubscriber("sub3", 5000);
        queue.subscribe(sub1, topic1);
        queue.subscribe(sub2, topic1);
        queue.subscribe(sub3, topic2);

        queue.publish(topic1, new Message("M1")); // 1 2
        queue.publish(topic1, new Message("M2")); // 1 2
        queue.publish(topic2, new Message("M3")); //3

        Thread.sleep(15000);

        queue.publish(topic2, new Message("M4")); //3
        queue.publish(topic1, new Message("M5")); //1 2

        queue.resetOffset(topic1,sub1 , 0);
    }
}