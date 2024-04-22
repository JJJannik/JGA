package de.jjjannik.entities;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.Player;
import lombok.Getter;

@Getter
public class PerformancePlayer extends Player {
    private final int performance;

    public PerformancePlayer(JsonObject object) {
        super(object);
        this.performance = object.get("performance").getAsInt();
    }
}