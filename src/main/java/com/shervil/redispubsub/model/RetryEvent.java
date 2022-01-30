package com.shervil.redispubsub.model;

import lombok.Data;
import lombok.Builder;
import java.util.UUID;
import java.io.Serializable;
import com.fasterxml.jackson.databind.JsonNode;

@Data
@Builder(toBuilder = true)
public class RetryEvent implements Serializable {

  private UUID id;
  private int retryCount;
  private String eventType;
  private JsonNode body;
}
