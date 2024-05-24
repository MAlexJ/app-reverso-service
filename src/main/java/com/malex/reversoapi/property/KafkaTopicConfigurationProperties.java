package com.malex.reversoapi.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("kafka-api")
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "kafka.topic")
public class KafkaTopicConfigurationProperties {
  private String in;
  private String out;
}
