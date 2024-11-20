package com.malex.core_module.mapper;

import org.mapstruct.Mapper;

import com.malex.core_module.model.api.CoreApiOutput;
import com.malex.core_module.model.web.ReversoResponse;

/**
 * MapStruct mapper:
 */
@Mapper(componentModel = "spring")
public interface CoreApiMapper {

    CoreApiOutput responseToOutput(ReversoResponse response);
}
