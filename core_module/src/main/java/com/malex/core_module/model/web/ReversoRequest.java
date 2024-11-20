package com.malex.core_module.model.web;

import com.malex.core_module.model.parameters.OptionsParameters;

public record ReversoRequest(String format, String from, String to, String input, OptionsParameters options) {

    public ReversoRequest(String format, String from, String to, String input) {
        this(format, from, to, input, new OptionsParameters(true, "translation.web", true, true));
    }
}
