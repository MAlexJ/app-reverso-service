package com.malex.core_module.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.malex.core_module.model.parameters.ContextResultParameters;
import com.malex.core_module.model.parameters.LanguageDetectionParameters;

import java.util.List;
import lombok.Data;

@Data
public class ReversoResponse {

    private String id;

    private String from;

    private String to;

    private List<String> input;

    private Object correctedText;

    private List<String> translation;

    private List<String> engines;

    @JsonProperty("languageDetection")
    private LanguageDetectionParameters language;

    @JsonProperty("contextResults")
    private ContextResultParameters contextResult;

    private boolean truncated;

    private int timeTaken;

}