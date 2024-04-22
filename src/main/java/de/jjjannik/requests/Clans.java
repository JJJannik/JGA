package de.jjjannik.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Clans {
    GET_DETAILS("https://api.greev.eu/v2/clan/%s"), // clanName
    GET_TOP("https://api.greev.eu/v2/clan/top?amount=%s&offset=%s"),
    GET_MEMBERS("https://api.greev.eu/v2/clan/members/%s"); // clanName

    private final String url;
}