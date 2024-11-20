package com.malex.rest_api_interface.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malex.rest_api_interface.model.RestApiRequest;
import com.malex.rest_api_interface.model.RestApiResponse;
import com.malex.rest_api_interface.service.RestApiService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api-translate")
@RequiredArgsConstructor
public class RestApiController {

    private final RestApiService service;

    /*
        HTTP POST:
     *
     * Use POST APIs to create new subordinate resources, e.g., a file is subordinate to a directory containing it
     * or a row is subordinate to a database table.
     *
     * When talking strictly about REST, POST methods are used to create a new resource into the collection of resources
     *
     * Responses to this method are not cacheable unless the response includes appropriate Cache-Control or Expires header fields.
     *
     * Please note that POST is neither safe nor idempotent, and invoking two identical POST requests will result
     * in two different resources containing the same information (except resource ids).
     *
     * link: https://restfulapi.net
     *
        POST API Response Codes:
     *
     * Ideally, if a resource has been created on the origin server, the response SHOULD be HTTP response code 201 (Created)
     * and contain an entity that describes the status of the request and refers to the new resource, and a Location header.

     * Many times, the action performed by the POST method might not result in a resource that can be identified by a URI.
     * In this case, either HTTP response code 200 (OK) or 204 (No Content) is the appropriate response status.
     */
    @PostMapping(path = "/translations",
/*
 * MIME type versioning: produces = "application/vnd.rest.api-v1+json"
 *
    When you develop REST APIs you may want to add different versions of that API in the future, say v1, v2 etc...,
    and different users of our API should be able to call the desired version.
 *
 * MIME Types:
 *
    JSON:API has been properly registered with the IANA.
    Its media type designation is application/vnd.api+json.
 *
 * It also helps in versioning the API.
 *
    `consumes` - matched only if the `Content-Type` request `header` matches
    `produces` - matched only if the `Accept` request `header` matches
 */
            produces = "application/vnd.rest.api-v1+json")
    public ResponseEntity<RestApiResponse> translate(@RequestBody RestApiRequest request) {
        log.debug("Http rest api request: {}", request);
        var response = service.translate(request);
        log.debug("Http rest api response: {}", response);
        return ResponseEntity.ok(response);
    }
}
