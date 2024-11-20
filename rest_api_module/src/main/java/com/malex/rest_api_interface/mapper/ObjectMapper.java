package com.malex.rest_api_interface.mapper;

import org.mapstruct.Mapper;

import com.malex.core_module.model.api.CoreApiInput;
import com.malex.core_module.model.api.CoreApiOutput;
import com.malex.rest_api_interface.model.RestApiRequest;
import com.malex.rest_api_interface.model.RestApiResponse;

/**
 * MapStruct mapper:
 */
@Mapper(componentModel = "spring")
public interface ObjectMapper {

    CoreApiInput requestToInput(RestApiRequest request);

    RestApiResponse outputToResponse(CoreApiOutput output);
}
