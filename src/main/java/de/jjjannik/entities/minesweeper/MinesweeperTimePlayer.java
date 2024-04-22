package de.jjjannik.entities.minesweeper;

import com.google.gson.JsonObject;
import de.jjjannik.requests.Minesweeper.Generator;
import de.jjjannik.requests.Minesweeper.Type;
import lombok.Getter;


@Getter
public class MinesweeperTimePlayer extends MinesweeperTimeEntry {
    private final Generator generator;
    private final Type type;

    public MinesweeperTimePlayer(JsonObject object) {
        super(object);
        this.generator = Generator.valueOf(object.get("generator").getAsString());
        this.type = Type.valueOf(object.get("type").getAsString());
    }
}