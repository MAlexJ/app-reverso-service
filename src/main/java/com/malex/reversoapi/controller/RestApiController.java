package com.malex.reversoapi.controller;

import com.malex.reversoapi.model.request.EngTranslationRequest;
import com.malex.reversoapi.model.response.ReversoResponse;
import com.malex.reversoapi.service.ReversoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class RestApiController {

  private final ReversoService service;

  @PostMapping("/translation")
  public ResponseEntity<Mono<ReversoResponse>> translation(
      @RequestBody EngTranslationRequest request) {
    return ResponseEntity.ok(service.translate(request));
  }
}
