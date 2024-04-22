package de.jjjannik.entities.basic;

import com.google.gson.JsonObject;
import lombok.Getter;

/**
 * Represents minigame player with only stats for kills and deaths
 */
@Getter
public class KillsDeathsPlayer extends Player {
    private final int kills;
    private final int deaths;

    public KillsDeathsPlayer(JsonObject object) {
        super(object);
        this.kills = object.get("kills").getAsInt();
        this.deaths = object.get("deaths").getAsInt();
    }
}