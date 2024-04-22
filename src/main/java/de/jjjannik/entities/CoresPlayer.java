package de.jjjannik.entities;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.PvPPlayer;
import lombok.Getter;

@Getter
public class CoresPlayer extends PvPPlayer {
    private final int brokenCores;

    public CoresPlayer(JsonObject object) {
        super(object);
        this.brokenCores = object.get("brokenCores").getAsInt();
    }
}