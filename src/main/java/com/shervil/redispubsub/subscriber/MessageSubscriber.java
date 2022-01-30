package com.shervil.redispubsub.subscriber;

public interface MessageSubscriber {
  void handleMessage(String message);
  String getTopicName();
}
