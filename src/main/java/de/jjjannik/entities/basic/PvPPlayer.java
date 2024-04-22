package de.jjjannik.entities.basic;

import com.google.gson.JsonObject;
import lombok.Getter;

/**
 * Represents minigame player with only stats for wins, loses, kills and deaths
 */
@Getter
public class PvPPlayer extends Player {
    private final int kills;
    private final int deaths;
    private final int wins;
    private final int loses;

    public PvPPlayer(JsonObject object) {
        super(object);
        this.kills = object.get("kills").getAsInt();
        this.deaths = object.get("deaths").getAsInt();
        this.wins = object.get("wins").getAsInt();
        this.loses = object.get("loses").getAsInt();
    }
}