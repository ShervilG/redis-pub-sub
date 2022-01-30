package com.shervil.redispubsub.subscriber;

import org.springframework.stereotype. Service;
import com.shervil.redispubsub.common.constant.Topic;

@Service
public class RetryMessageSubscriber implements MessageSubscriber {

  @Override
  public void handleMessage(String message) {
    System.out.println(Thread.currentThread().getId());
    System.out.println("Received message : " + message);
  }

  @Override
  public String getTopicName() {
    return Topic.RETRY_EVENT.getTopicValue();
  }
}
