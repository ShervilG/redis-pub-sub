package com.shervil.redispubsub.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorConfiguration {

  @Value("${executor.pool.size}")
  private int pubSubExecutorPoolSize;

  @Bean
  Executor pubSubExecutor() {
    return Executors.newFixedThreadPool(pubSubExecutorPoolSize);
  }
}
