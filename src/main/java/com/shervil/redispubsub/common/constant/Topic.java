package com.shervil.redispubsub.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Topic {

  RETRY_EVENT("retry-event");

  private String topicValue;
}
