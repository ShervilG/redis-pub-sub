package com.shervil.redispubsub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class RedisPubSubApplication {

  public static void main(String[] args) {
    SpringApplication.run(RedisPubSubApplication.class, args);
  }

}
