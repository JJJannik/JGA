package de.jjjannik.entities.minesweeper;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.Player;
import lombok.Getter;

@Getter
public class MinesweeperPlayer extends Player {
    private final int rounds;
    private final int incorrectPlacedFlags;
    private final int correctPlacedFlags;
    private final int mastery;

    public MinesweeperPlayer(JsonObject object) {
        super(object);
        this.rounds = object.get("rounds").getAsInt();
        this.incorrectPlacedFlags = object.get("incorrectPlacedFlags").getAsInt();
        this.correctPlacedFlags = object.get("correctPlacedFlags").getAsInt();
        this.mastery = object.get("master").getAsInt();
    }
}