package com.malex.reversoapi.model.response;

import java.util.List;
import lombok.Data;

@Data
public class ContextResult {
  private boolean rudeWords;
  private boolean colloquialisms;
  private boolean riskyWords;
  private List<Result> results;
  private int totalContextCallsMade;
  private int timeTakenContext;
}
