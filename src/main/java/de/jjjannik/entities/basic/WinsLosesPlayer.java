package de.jjjannik.entities.basic;

import com.google.gson.JsonObject;
import lombok.Getter;

/**
 * Represents minigame player with only stats for wins and loses.
 */
@Getter
public class WinsLosesPlayer extends Player {
    private final int wins;
    private final int loses;

    public WinsLosesPlayer(JsonObject object) {
        super(object);
        this.wins = object.get("wins").getAsInt();
        this.loses = object.get("loses").getAsInt();
    }
}