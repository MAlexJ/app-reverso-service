package com.malex.rest_api_interface.model.parameters;

import java.util.List;
import lombok.Data;

@Data
public class ResultParameters {

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
