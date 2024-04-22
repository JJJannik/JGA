package de.jjjannik.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PlayerMetadata {
    GET_DATA("https://api.greev.eu/v2/player/meta/%s");

    private final String url;
}