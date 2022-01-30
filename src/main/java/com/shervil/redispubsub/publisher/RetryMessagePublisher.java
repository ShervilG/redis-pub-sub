package com.shervil.redispubsub.publisher;

import org.springframework.stereotype.Service;
import com.shervil.redispubsub.common.constant.Topic;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RetryMessagePublisher implements MessagePublisher {

  @Autowired
  private RedisTemplate<String, Object> redisTemplate;

  @Override
  public void publishMessage(Object message) {
    this.redisTemplate.convertAndSend(Topic.RETRY_EVENT.getTopicValue(), message.toString());
  }

  @Override
  public String getTopic() {
    return Topic.RETRY_EVENT.getTopicValue();
  }
}
