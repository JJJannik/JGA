package de.jjjannik.entities;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.Player;
import lombok.Getter;

@Getter
public class TokensPlayer extends Player {
    private final int tokens;

    public TokensPlayer(JsonObject object) {
        super(object);
        this.tokens = object.get("tokens").getAsInt();
    }
}