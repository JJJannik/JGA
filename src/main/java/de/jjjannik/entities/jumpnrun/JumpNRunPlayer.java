package de.jjjannik.entities.jumpnrun;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.Player;
import lombok.Getter;

@Getter
public class JumpNRunPlayer extends Player {
    private final int time;
    private final int jumpAndRunId;
    private final int fails;
    private final int checkpoints;

    public JumpNRunPlayer(JsonObject object) {
        super(object);
        this.time = object.get("time").getAsInt();
        this.jumpAndRunId = object.get("jumpAndRunId").getAsInt();
        this.fails = object.get("fails").getAsInt();
        this.checkpoints = object.get("checkpoints").getAsInt();
    }
}