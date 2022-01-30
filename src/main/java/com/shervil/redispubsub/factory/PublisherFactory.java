package com.shervil.redispubsub.factory;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import org.springframework.stereotype.Component;
import com.shervil.redispubsub.publisher.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class PublisherFactory {

  private final Map<String, MessagePublisher> messagePublisherMap;

  @Autowired
  PublisherFactory(
      List<MessagePublisher> messagePublisherList
  ) {
    this.messagePublisherMap = new HashMap<>();
    messagePublisherList.forEach(
        messagePublisher -> this.messagePublisherMap.put(messagePublisher.getTopic(), messagePublisher)
    );
  }

  public void publish(String topic, Object message) {
    if (this.messagePublisherMap.containsKey(topic)) {
      this.messagePublisherMap.get(topic).publishMessage(message);
    }
  }
}
