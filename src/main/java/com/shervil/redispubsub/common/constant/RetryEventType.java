package com.shervil.redispubsub.common.constant;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
enum RetryEventType {

  EMAIL("email");

  private String type;
}
