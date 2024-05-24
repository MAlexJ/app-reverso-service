package com.malex.reversoapi.kafka.consumer;

import com.malex.reversoapi.model.event.TranslationEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Profile("kafka-api")
@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

  private final ReactiveKafkaConsumerTemplate<String, TranslationEvent> reactiveKafkaConsumer;

  @EventListener(ApplicationStartedEvent.class)
  public Flux<TranslationEvent> consumerEventListener() {
    return reactiveKafkaConsumer
        .receiveAutoAck()
        .doOnNext(
            consumerRecord ->
                log.info(
                    "Received event: key - {}, value - {}, topic - {}, partition - {} offset - {}",
                    consumerRecord.key(),
                    consumerRecord.value(),
                    consumerRecord.topic(),
                    consumerRecord.partition(),
                    consumerRecord.offset()))
        .map(ConsumerRecord::value)
        .doOnError(throwable -> log.error("Error - {}", throwable.getMessage()));
  }
}
