package de.jjjannik.entities.minesweeper;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.Player;
import lombok.Getter;

@Getter
public class MinesweeperTopEntry extends Player {
    private Integer time = null;
    private Integer mastery = null;

    public MinesweeperTopEntry(JsonObject object) {
        super(object);
        if (object.get("time") != null) this.time = object.get("time").getAsInt();
        if (object.get("mastery") != null) this.mastery = object.get("mastery").getAsInt();
    }}