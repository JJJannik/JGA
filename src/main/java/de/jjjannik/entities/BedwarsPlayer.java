package de.jjjannik.entities;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.PvPPlayer;
import lombok.Getter;

@Getter
public class BedwarsPlayer extends PvPPlayer {
    private final int brokenBeds;

    public BedwarsPlayer(JsonObject object) {
        super(object);
        this.brokenBeds = object.get("brokenBeds").getAsInt();
    }
}