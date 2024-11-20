package com.malex.rest_api_interface.model.parameters;

import lombok.Data;

@Data
public class LanguageDetectionParameters {

    private String detectedLanguage;

    private boolean isDirectionChanged;

    private String originalDirection;

    private int originalDirectionContextMatches;

    private int changedDirectionContextMatches;

    private int timeTaken;
}
