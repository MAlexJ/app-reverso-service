package com.malex.core_module.service.impl;

import org.springframework.stereotype.Service;

import com.malex.core_module.mapper.MapperService;
import com.malex.core_module.model.api.CoreApiInput;
import com.malex.core_module.model.api.CoreApiOutput;
import com.malex.core_module.service.CoreApiService;
import com.malex.core_module.webservice.WebRestClientService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CoreApiServiceImpl implements CoreApiService {

    private final MapperService mapperService;

    private final WebRestClientService webservice;

    @Override
    public CoreApiOutput translate(CoreApiInput input) {
        log.debug("Core API input -{}", input);
        var request = mapperService.inputToRequest(input);
        var response = webservice.post(request);
        var output = mapperService.responseToOutput(response);
        log.debug("Core API output - {}", output);
        return output;
    }
}
