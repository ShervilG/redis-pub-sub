package com.shervil.redispubsub.config;

import com.shervil.redispubsub.common.constant.Topic;
import com.shervil.redispubsub.factory.ConsumerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfiguration {

  @Value("${spring.redis.password}")
  private String password;

  @Value("${spring.redis.host}")
  private String host;

  @Value("${spring.redis.port}")
  private int port;

  @Autowired
  private ConsumerFactory consumerFactory;

  @Bean
  LettuceConnectionFactory lettuceConnectionFactory() {
    LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory();
    lettuceConnectionFactory.setHostName(host);
    lettuceConnectionFactory.setPassword(password);
    lettuceConnectionFactory.setPort(port);

    return lettuceConnectionFactory;
  }

  @Bean
  RedisTemplate<String, Object> redisTemplate() {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(lettuceConnectionFactory());
    template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));

    return template;
  }

  @Bean
  MessageListener retryMessageListener() {
    return new MessageListenerAdapter(this.consumerFactory.getSubscriber(Topic.RETRY_EVENT.getTopicValue()));
  }

  @Bean
  ChannelTopic retryChannelTopic() {
    return new ChannelTopic(Topic.RETRY_EVENT.getTopicValue());
  }

  @Bean
  RedisMessageListenerContainer redisMessageListenerContainer() {
    RedisMessageListenerContainer container
        = new RedisMessageListenerContainer();
    container.setConnectionFactory(lettuceConnectionFactory());
    container.addMessageListener(retryMessageListener(), retryChannelTopic());

    return container;
  }
}
