package de.jjjannik.utils.web;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class HttpResponse {
    private String body;
    private int responseCode;
    private String responseMessage;
}