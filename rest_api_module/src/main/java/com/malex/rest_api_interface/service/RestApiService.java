package com.malex.rest_api_interface.service;

import org.springframework.stereotype.Service;

import com.malex.core_module.model.api.CoreApiOutput;
import com.malex.core_module.service.CoreApiService;
import com.malex.rest_api_interface.mapper.ObjectMapper;
import com.malex.rest_api_interface.model.RestApiRequest;
import com.malex.rest_api_interface.model.RestApiResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestApiService {

    private final ObjectMapper mapper;

    private final CoreApiService service;

    public RestApiResponse translate(RestApiRequest request) {
        var input = mapper.requestToInput(request);
        CoreApiOutput output = service.translate(input);
        return mapper.outputToResponse(output);
    }

}
