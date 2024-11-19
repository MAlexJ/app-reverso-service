package com.malex.reversoapi.webservice;

import com.malex.reversoapi.model.request.ReversoRequest;
import com.malex.reversoapi.model.response.ReversoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReversoWebService {

  private final WebClient webClient;

  @Value("${reverso.url}")
  private String baseUrl;

  @Value("${reverso.header.key}")
  private String headerKey;

  @Value("${reverso.header.value}")
  private String headerValue;

  public Mono<ReversoResponse> translate(ReversoRequest body) {
    return webClient
        .post()
        .uri(baseUrl)
        .bodyValue(body)
        .header(headerKey, headerValue)
        .retrieve()
        .bodyToMono(ReversoResponse.class)
        .doOnNext(response -> log.info("HTTP response - {}", response));
  }
}
