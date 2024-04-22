package de.jjjannik.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PlayerStats {
    GET_ALL_STATS("https://api.greev.eu/v2/player/stats/%s");

    private final String url;
}