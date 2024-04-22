package de.jjjannik.utils.web;

import java.io.IOException;
import java.util.Optional;

public interface HttpRequestInterface {
    Optional<HttpResponse> doRequest(String apiUrl) throws IOException;
}