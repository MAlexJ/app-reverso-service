package com.malex.reversoapi.service;

import com.malex.reversoapi.model.request.ReversoRequest;
import com.malex.reversoapi.model.request.EngTranslationRequest;
import com.malex.reversoapi.model.response.ReversoResponse;
import com.malex.reversoapi.webservice.ReversoWebService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ReversoService {

  private final ReversoWebService webService;

  public Mono<ReversoResponse> translate(EngTranslationRequest request) {
    var reversoRequest = new ReversoRequest(request.text());
    return webService.translate(reversoRequest);
  }
}
