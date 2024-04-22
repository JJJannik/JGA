package de.jjjannik.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FastbridgeIslands {
    GET_TOP("https://api.greev.eu/v2/stats/fastbridge_islands/top/%s?amount=%s&offset=%s"), // Map - amount - offset
    GET_PLAYER("https://api.greev.eu/v2/stats/fastbridge_islands/player/%s");

    private final String url;

    public enum Map {
        CUBES,
        RAILS,
        STREET,
        CORAL,
        ATHEN
    }
}