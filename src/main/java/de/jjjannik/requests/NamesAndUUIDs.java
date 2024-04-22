package de.jjjannik.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NamesAndUUIDs {
    GET_UUID("https://api.greev.eu/v2/player/uuid/%s"),
    GET_NAME_HISTORY("https://api.greev.eu/v2/player/namehistory/%s"),
    GET_NAME("https://api.greev.eu/v2/player/name/%s");

    private final String url;
}