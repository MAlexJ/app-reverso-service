package com.malex.core_module.model.parameters;

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
