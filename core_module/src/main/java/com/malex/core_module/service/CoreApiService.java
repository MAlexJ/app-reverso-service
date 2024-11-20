package com.malex.core_module.service;

import com.malex.core_module.model.api.CoreApiInput;
import com.malex.core_module.model.api.CoreApiOutput;

public interface CoreApiService {

    CoreApiOutput translate(CoreApiInput input);
}
