package com.shervil.redispubsub.factory;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import org.springframework.stereotype.Component;
import com.shervil.redispubsub.subscriber.MessageSubscriber;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ConsumerFactory {

  private final Map<String, MessageSubscriber> messageSubscriberMap;

  @Autowired
  ConsumerFactory(
      List<MessageSubscriber> messageSubscriberList
  ) {
    this.messageSubscriberMap = new HashMap<>();
    messageSubscriberList.forEach(
        messageSubscriber -> this.messageSubscriberMap.put(messageSubscriber.getTopicName(), messageSubscriber)
    );
  }

  /** Helps in RedisConfiguration. */
  public MessageSubscriber getSubscriber(String topic) {
    return this.messageSubscriberMap.get(topic);
  }
}
