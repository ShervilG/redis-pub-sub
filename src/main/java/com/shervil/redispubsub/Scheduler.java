package com.shervil.redispubsub;

import com.shervil.redispubsub.publisher.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Scheduler {

  private static int messageNumber = 1;

  @Autowired
  private MessagePublisher messagePublisher;

  @Scheduled(fixedRate = 300)
  void doSomething() {
    messagePublisher.publishMessage("okay" + (messageNumber++));
  }
}
