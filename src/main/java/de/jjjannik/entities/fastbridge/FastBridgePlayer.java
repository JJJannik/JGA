package de.jjjannik.entities.fastbridge;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.Player;
import lombok.Getter;

@Getter
public class FastBridgePlayer extends Player {
    private final float time;
    private final String replayId;
    private final String mode;
    private final String timestamp;

    public FastBridgePlayer(JsonObject object) {
        super(object);
        this.time = object.get("time").getAsFloat();
        this.replayId = object.get("replayId").getAsString();
        this.mode = object.get("mode").getAsString();
        this.timestamp = object.get("timestamp").getAsString();
    }
}