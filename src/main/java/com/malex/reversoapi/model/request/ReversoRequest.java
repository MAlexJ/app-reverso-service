package com.malex.reversoapi.model.request;

public record ReversoRequest(String format, String from, String to, String input, Options options) {

  public ReversoRequest(String text) {
    this("text", "eng", "rus", text, new Options(true, "translation.web", true, true));
  }
}
