package com.malex.reversoapi.model.response;

import lombok.Data;

import java.util.List;

@Data
public class Result {
  private String translation;
  private List<String> sourceExamples;
  private List<String> targetExamples;
  private boolean rude;
  private boolean colloquial;
  private String partOfSpeech;
  private int frequency;
  private Object vowels;
  private String transliteration;
}
