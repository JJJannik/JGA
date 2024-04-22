package de.jjjannik.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Badges {
    GET_PLAYER("https://api.greev.eu/v2/badge/player/%s"); // uuid

    private final String url;
}