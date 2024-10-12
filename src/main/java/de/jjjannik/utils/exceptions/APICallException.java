package de.jjjannik.utils.exceptions;

import lombok.Getter;

/**
 * Thrown if an application requests a Greev API endpoint.
 * <p>
 * Examples for why this call could happen, depending on the Greev API:
 * <ul>
 * <li>Player with <b>{@code uuid}</b> does not exist or Player does not have any stats in the Minigame</li>
 * <li>Sorting param <b>{@code amount}</b>, <b>{@code offset}</b>, <b>{@code startTimestamp}</b> or <b>{@code endTimestamp}</b> is below zero</li>
 * <li>Generally name for player, Fastbridge map, KnockPvPLab experiment, Minesweeper Type or a Minesweeper Game ID does not exist</li>
 * <li>Will also throw, when gotten stats from Player do not exist. Getting top stats returns only an empty string if no players are found</li>
 * </ul>
 */

@Getter
public class APICallException extends RuntimeException {
    private final int responseCode;

    /**
     * Constructs an {@code APICallException} with no detail message.
     */
    public APICallException(int responseCode) {
        super();
        this.responseCode = responseCode;
    }

    /**
     * Constructs an {@code APICallException} with the specified
     * detail message.
     *
     * @param   responseMessage   the detail message.
     */
    public APICallException(String responseMessage, int responseCode) {
        super(responseMessage);
        this.responseCode = responseCode;
    }
}