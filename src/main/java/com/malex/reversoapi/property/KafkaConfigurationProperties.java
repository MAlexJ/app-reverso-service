package com.malex.reversoapi.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("kafka-api")
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "kafka.server")
public class KafkaConfigurationProperties {
    private String bootstrapServer;
    private String propertySecurityProtocol;
    private String propertySaslMechanism;
    private String propertySaslJaasConfig;
}
