package com.malex.reversoapi.model.request;

public record Options(
    boolean sentenceSplitter, String origin, boolean contextResults, boolean languageDetection) {}
