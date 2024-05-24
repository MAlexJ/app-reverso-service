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

  private String url = "https://api.reverso.net/translate/v1/translation";

  public Mono<ReversoResponse> translate(ReversoRequest request) {
    return webClient
        .post()
        .uri(url)
        .bodyValue(request)
        .header(
            "User-Agent",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36 Edg/125.0.0.0")
        .retrieve()
        .bodyToMono(ReversoResponse.class)
        .doOnNext(response -> log.info("HTTP response - {}", response));
  }
}
