package com.malex.core_module.webservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.malex.core_module.model.web.ReversoRequest;
import com.malex.core_module.model.web.ReversoResponse;

@Service
public class WebRestClientService {

    private final RestClient restClient;

    @Value("${reverso.header.key}")
    private String headerKey;

    @Value("${reverso.header.value}")
    private String headerValue;

    public WebRestClientService(@Value("${reverso.url}") String baseUrl, RestClient.Builder builder) {
        this.restClient = builder.baseUrl(baseUrl).build();
    }

    public ReversoResponse post(ReversoRequest jsonBody) {
        return restClient.post().body(jsonBody).header(headerKey, headerValue).retrieve().body(ReversoResponse.class);
    }
}
