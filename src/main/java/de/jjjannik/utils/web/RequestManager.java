package de.jjjannik.utils.web;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.jjjannik.JGAInitializer;
import de.jjjannik.utils.exceptions.APICallException;
import de.jjjannik.utils.exceptions.APITimeoutException;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Optional;

/**
 * This class is used to manage the intern web requests
 */

@Log4j2
public class RequestManager {
    private static final UnsafeHttpRequest request = new UnsafeHttpRequest();

    public @NotNull JsonElement requestData(String uri) {
        JsonElement element = new JsonObject();
        try {
            Optional<HttpResponse> optionalResponse;
            try {
                optionalResponse = request.doRequest(uri);
            } catch (SocketTimeoutException e) {
                throw new APITimeoutException("Request timeout");
            }

            if (optionalResponse.isPresent()) {
                HttpResponse response = optionalResponse.get();
                element = JGAInitializer.getGson().fromJson(response.getBody(), JsonElement.class);

                if (response.getResponseCode() >= 400) {
                    throw new APICallException("Incorrect API call, check APICallException class description to find out why this could happened");
                }
            }
        } catch (IOException e) {
            log.error("Could not request API", e);
        }
        return element;
    }
}