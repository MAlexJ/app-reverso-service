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
@ConfigurationProperties(prefix = "kafka.producer")
public class KafkaProducerConfigurationProperties {
    private String keySerializer;
    private String valueSerializer;
    private Boolean propertyEnableIdempotence;
    private Boolean propertySpringJsonAddTypeHeaders;
}

