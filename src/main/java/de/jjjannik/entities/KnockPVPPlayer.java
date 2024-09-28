package de.jjjannik.entities;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.KillsDeathsPlayer;
import lombok.Getter;

@Getter
public class KnockPVPPlayer extends KillsDeathsPlayer {
    private final int rank;

    public KnockPVPPlayer(JsonObject object) {
        super(object);
        rank = object.get("rank").getAsInt();
    }
}