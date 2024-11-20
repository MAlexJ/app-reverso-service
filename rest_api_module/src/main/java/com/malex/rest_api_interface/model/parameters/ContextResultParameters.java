package com.malex.rest_api_interface.model.parameters;

import java.util.List;
import lombok.Data;


@Data
public class ContextResultParameters {

    private boolean rudeWords;

    private boolean colloquialisms;

    private boolean riskyWords;

    private List<ResultParameters> results;

    private int totalContextCallsMade;

    private int timeTakenContext;
}
