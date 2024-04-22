package de.jjjannik.utils.web;

import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Optional;

/**
 * DO NOT USE THIS CLASS EVERYWHERE! IT WILL TRUST ALL SSL CERTS!
 */
public class UnsafeHttpRequest implements HttpRequestInterface {
    private static final UnsafeHttpClient unsafeHttpClient = new UnsafeHttpClient();

    protected UnsafeHttpRequest() {}

    @Override
    public Optional<HttpResponse> doRequest(String apiUrl) throws IOException {
        Request.Builder builder = new Request.Builder()
            .url(apiUrl)
            .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

        HttpResponse response;
        try (Response httpResponse = unsafeHttpClient.getClient().newCall(builder.build()).execute()) {
            HttpResponse.HttpResponseBuilder responseBuilder = HttpResponse.builder()
                .responseCode(httpResponse.code())
                .responseMessage(httpResponse.message());

            if (!httpResponse.isSuccessful() || httpResponse.body() == null) {
                return Optional.ofNullable(responseBuilder.build());
            }

            response = responseBuilder
                .body(httpResponse.body().string())
                .build();
        }

        return Optional.ofNullable(response);
    }
}