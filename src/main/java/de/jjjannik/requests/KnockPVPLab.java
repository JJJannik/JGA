package de.jjjannik.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum KnockPVPLab { // endpoint: /experiment/ [params]
    GET_TOP("https://api.greev.eu/v2/stats/knockpvplab/top/%s?amount=%s&offset=%s"),
    GET_PLAYER("https://api.greev.eu/v2/stats/knockpvplab/player/%s/%s"),
    GET_ROLLING_TOP("https://api.greev.eu/v2/stats/knockpvplab/rollingTop/%s?amount=%s&offset=%s&startTimestamp=%s&endTimestamp=%s"),
    GET_ROLLING_PLAYER("https://api.greev.eu/v2/stats/knockpvplab/rolling/%s/%s?startTimestamp=%s&endTimestamp=%s");

    private final String url;
}