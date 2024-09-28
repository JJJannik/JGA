package de.jjjannik.utils.exceptions;

/**
 * Thrown if a requests to a Greev API endpoint timeouts e.g. due to long response time by the Greev API.
 */
public class APITimeoutException extends RuntimeException {
    /**
     * Constructs an {@code APITimeoutException} with no detail message.
     */
    public APITimeoutException() {
        super();
    }

    /**
     * Constructs an {@code APITimeoutException} with the specified
     * detail message.
     *
     * @param   message   the detail message.
     */
    public APITimeoutException(String message) {
        super(message);
    }
}