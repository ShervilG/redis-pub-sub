package com.shervil.redispubsub.publisher;

public interface MessagePublisher {
  void publishMessage(Object message);
  String getTopic();
}
