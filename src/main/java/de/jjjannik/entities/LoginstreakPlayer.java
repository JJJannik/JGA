package de.jjjannik.entities;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.Player;
import lombok.Getter;

@Getter
public class LoginstreakPlayer extends Player {
    private final int currentStreak;
    private final int maxStreak;

    public LoginstreakPlayer(JsonObject object) {
        super(object);
        this.currentStreak = object.get("currenttreak").getAsInt();
        this.maxStreak = object.get("maxstreak").getAsInt();
    }
}