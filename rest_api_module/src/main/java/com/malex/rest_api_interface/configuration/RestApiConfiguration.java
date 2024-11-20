package com.malex.rest_api_interface.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.malex.core_module.configuration.CoreApplicationConfiguration;


@Configuration
@Import(CoreApplicationConfiguration.class)
public class RestApiConfiguration {
}
