package com.malex.core_module.validation;

import org.springframework.stereotype.Service;

import com.malex.core_module.model.api.CoreApiInput;

import java.util.Objects;

@Service
public class ValidationService {

    public void validate(CoreApiInput input) {
        Objects.requireNonNull(input.input(), "Input can not be null");
    }
}
