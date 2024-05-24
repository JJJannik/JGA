package de.jjjannik.utils.exceptions;

/**
 * Thrown if an application requests a Greev API endpoint.
 * <p>
 * Examples for why this call could happen, depending on the Greev API:
 * <ul>
 * <li>Player with <b>{@code uuid}</b> does not exist or Player does not have any stats in the Minigame</li>
 * <li>Sorting param <b>{@code amount}</b>, <b>{@code offset}</b>, <b>{@code startTimestamp}</b> or <b>{@code endTimestamp}</b> is below zero</li>
 * <li>Generally name for player, Fastbridge map, KnockPvPLab experiment, Minesweeper Type, Minesweeper Game ID or clan does not exist</li>
 * <li>Will also throw, when gotten stats from Player do not exist. Getting top stats returns only an empty string if no players are found</li>
 * </ul>
 */
public class APICallException extends RuntimeException {

    /**
     * Constructs an {@code APICallException} with no detail message.
     */
    public APICallException() {
        super();
    }

    /**
     * Constructs an {@code APICallException} with the specified
     * detail message.
     *
     * @param   message   the detail message.
     */
    public APICallException(String message) {
        super(message);
    }
}