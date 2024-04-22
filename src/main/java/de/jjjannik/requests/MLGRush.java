package de.jjjannik.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MLGRush {
    GET_TOP("https://api.greev.eu/v2/stats/mlgrush/top?amount=%s&offset=%s"),
    GET_PLAYER("https://api.greev.eu/v2/stats/mlgrush/player/%s"),
    GET_ROLLING_TOP("https://api.greev.eu/v2/stats/mlgrush/rollingTop?amount=%s&offset=%s&startTimestamp=%s&endTimestamp=%s"),
    GET_ROLLING_PLAYER("https://api.greev.eu/v2/stats/mlgrush/rolling/%s?startTimestamp=%s&endTimestamp=%s");

    private final String url;
}