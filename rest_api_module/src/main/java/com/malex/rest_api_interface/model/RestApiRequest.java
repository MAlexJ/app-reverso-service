package com.malex.rest_api_interface.model;

import lombok.Data;

@Data
public class RestApiRequest {

    private String format;

    private String from;

    private String to;

    private String input;
}
