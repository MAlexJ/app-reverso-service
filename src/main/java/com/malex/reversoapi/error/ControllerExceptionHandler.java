package com.malex.reversoapi.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception Handling with Spring for a REST API:
 * <li>Exception Handling in Spring MVC:
 *     https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
 * <li>Error Handling for REST with Spring:
 *     https://www.baeldung.com/exception-handling-for-rest-with-spring
 */
@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(Exception.class)
  ProblemDetail handleBookmarkNotFoundException(Exception e) {
    var problemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
    problemDetail.setTitle(e.getMessage());
    return problemDetail;
  }
}
