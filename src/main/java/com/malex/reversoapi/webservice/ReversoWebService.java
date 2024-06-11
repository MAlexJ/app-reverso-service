package com.malex.reversoapi.webservice;

import com.malex.reversoapi.model.request.ReversoRequest;
import com.malex.reversoapi.model.response.ReversoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReversoWebService {

  private final WebClient webClient;

  private static final String REVERSO_URL = "https://api.reverso.net/translate/v1/translation";

  private static final String HEADER_KEY = "User-Agent";
  private static final String HEADER_VALUE =
      "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36 Edg/125.0.0.0";

  public Mono<ReversoResponse> translate(ReversoRequest request) {
    return webClient
        .post()
        .uri(REVERSO_URL)
        .bodyValue(request)
        .header(HEADER_KEY, HEADER_VALUE)
        .retrieve()
        .bodyToMono(ReversoResponse.class)
        .doOnNext(response -> log.info("HTTP response - {}", response));
  }
}
