package de.jjjannik.entities;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.PvPPlayer;
import lombok.Getter;

@Getter
public class RushPlayer extends PvPPlayer {
    private final int brokenBeds;

    public RushPlayer(JsonObject object) {
        super(object);
        this.brokenBeds = object.get("brokenBeds").getAsInt();
    }
}