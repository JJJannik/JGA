package de.jjjannik.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum KnockPVP {
    GET_TOP("https://api.greev.eu/v2/stats/knockpvp/top?amount=%s&offset=%s"),
    GET_PLAYER("https://api.greev.eu/v2/stats/knockpvp/player/%s"),
    GET_ROLLING_TOP("https://api.greev.eu/v2/stats/knockpvp/rollingTop?amount=%s&offset=%s&startTimestamp=%s&endTimestamp=%s"),
    GET_ROLLING_PLAYER("https://api.greev.eu/v2/stats/knockpvp/rolling/%s?startTimestamp=%s&endTimestamp=%s");

    private final String url;
}