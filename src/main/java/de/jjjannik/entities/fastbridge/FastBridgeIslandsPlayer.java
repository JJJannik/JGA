package de.jjjannik.entities.fastbridge;

import com.google.gson.JsonObject;
import lombok.Getter;

@Getter
public class FastBridgeIslandsPlayer extends FastBridgePlayer {
    private final String map;

    public FastBridgeIslandsPlayer(JsonObject object) {
        super(object);
        this.map = object.get("map").getAsString();
    }
}