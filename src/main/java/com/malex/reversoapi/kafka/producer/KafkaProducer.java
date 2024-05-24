package com.malex.reversoapi.kafka.producer;

import com.malex.reversoapi.model.event.TranslationProcessingEvent;
import com.malex.reversoapi.property.KafkaTopicConfigurationProperties;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Profile("kafka-api")
@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {

  private final KafkaTopicConfigurationProperties topicProperty;
  private final ReactiveKafkaProducerTemplate<String, TranslationProcessingEvent>
      reactiveKafkaProducer;

  public Mono<TranslationProcessingEvent> sendMessage(TranslationProcessingEvent event) {
    var key = UUID.randomUUID().toString();
    return reactiveKafkaProducer
        .send(topicProperty.getOut(), UUID.randomUUID().toString(), event)
        .doOnSuccess(
            senderResult -> {
              Exception exception = senderResult.exception();
              if (exception != null) {
                log.warn("Exception occurred while sending event", exception);
              }
              var recordMetadata = senderResult.recordMetadata();
              log.info(
                  "Send event: key - {}, value - {}, topic - {}, partition - {} offset - {}",
                  key,
                  event,
                  recordMetadata.topic(),
                  recordMetadata.partition(),
                  recordMetadata.offset());
            })
        .map(voidSenderResult -> event);
  }
}
