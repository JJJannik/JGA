package de.jjjannik.entities;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.Player;
import lombok.Getter;

@Getter
public class FastBridgePlayer extends Player {
    private final float time;
    // private final String replayId;       -> according to the API docs this should be existent, but isn't contained in the Json response
    private final String map;
    private final String mode;
    private final String timestamp;

    public FastBridgePlayer(JsonObject object) {
        super(object);
        this.time = object.get("time").getAsFloat();
        // this.replayId = object.get("replayId").getAsString();
        this.map = object.get("map") == null ? null : object.get("map").getAsString();
        this.mode = object.get("mode").getAsString();
        this.timestamp = object.get("timestamp").getAsString();
    }
}