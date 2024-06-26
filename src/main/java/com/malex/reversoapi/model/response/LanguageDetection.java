package com.malex.reversoapi.model.response;

import lombok.Data;

@Data
public class LanguageDetection {
  private String detectedLanguage;
  private boolean isDirectionChanged;
  private String originalDirection;
  private int originalDirectionContextMatches;
  private int changedDirectionContextMatches;
  private int timeTaken;
}
