package de.jjjannik.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AdventJnRs {
    GET_TOP("https://api.greev.eu/v2/stats/advent/top/%s/%s?amount=%s&offset=%s"), // year - day/id - amount &| offset
    GET_ALL_PLAYER("https://api.greev.eu/v2/stats/advent/player/%s/%s"), // uuid - year
    GET_ALL_PLAYER_DATE("https://api.greev.eu/v2/stats/advent/player/%s/%s/%s"); // uuid - year - day/id

    private final String url;
}