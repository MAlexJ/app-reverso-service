package com.malex.core_module.mapper;

import org.springframework.stereotype.Service;

import com.malex.core_module.model.api.CoreApiInput;
import com.malex.core_module.model.api.CoreApiOutput;
import com.malex.core_module.model.web.ReversoRequest;
import com.malex.core_module.model.web.ReversoResponse;
import com.malex.core_module.validation.ValidationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MapperService {

    private final CoreApiMapper mapper;

    private final ValidationService validationService;

    public ReversoRequest inputToRequest(CoreApiInput coreModuleInput) {
        validationService.validate(coreModuleInput);
        var format = coreModuleInput.format();
        var from = coreModuleInput.from();
        var to = coreModuleInput.to();
        var input = coreModuleInput.input();
        return new ReversoRequest(format, from, to, input);
    }

    public CoreApiOutput responseToOutput(ReversoResponse response) {
        return mapper.responseToOutput(response);
    }
}
