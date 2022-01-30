package com.shervil.redispubsub.service;

import com.shervil.redispubsub.model.RetryEvent;

public interface RetryEventHandler {
  void handleRetryEvent(RetryEvent retryEvent);
}
