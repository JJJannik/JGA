package de.jjjannik.entities.minesweeper;

import com.google.gson.JsonObject;
import lombok.Getter;

@Getter
public class MinesweeperBestPlayer extends MinesweeperTimeEntry {
    private final int roundId;
    private final String timestamp;

    public MinesweeperBestPlayer(JsonObject object) {
        super(object);
        this.roundId = object.get("roundId").getAsInt();
        this.timestamp = object.get("timestamp").getAsString();
    }
}