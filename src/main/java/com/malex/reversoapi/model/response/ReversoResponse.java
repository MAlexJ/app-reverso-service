package com.malex.reversoapi.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
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
  private LanguageDetection language;

  @JsonProperty("contextResults")
  private ContextResult contextResult;

  private boolean truncated;
  private int timeTaken;
}
