package de.jjjannik.entities.minesweeper;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.Player;
import lombok.Getter;

@Getter
public class MinesweeperTimeEntry extends Player {
    private final int time;

    public MinesweeperTimeEntry(JsonObject object) {
        super(object);
        this.time = object.get("time").getAsInt();
    }
}