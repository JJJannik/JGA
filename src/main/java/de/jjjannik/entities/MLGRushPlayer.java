package de.jjjannik.entities;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.WinsLosesPlayer;
import lombok.Getter;

@Getter
public class MLGRushPlayer extends WinsLosesPlayer {
    private final int brokenBeds;
    private final int lostBeds;

    public MLGRushPlayer(JsonObject object) {
        super(object);
        this.brokenBeds = object.get("brokenBeds").getAsInt();
        this.lostBeds = object.get("lostBeds").getAsInt();
    }
}