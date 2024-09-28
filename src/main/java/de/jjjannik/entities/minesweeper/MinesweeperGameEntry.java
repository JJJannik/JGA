package de.jjjannik.entities.minesweeper;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.DataEntity;
import de.jjjannik.requests.Minesweeper.Generator;
import de.jjjannik.requests.Minesweeper.Type;
import lombok.Getter;

import java.util.UUID;

@Getter
public class MinesweeperGameEntry extends DataEntity {
    private final UUID uuid;
    private final Type type;
    private final int time;
    private final String timestamp;
    private final Generator generator;
    private String gameData = null;
    private final String saveField;
    private final int mines;
    private final int correctFlags;
    private final int incorrectFlags;
    private final boolean won;
    private final int xSize;
    private final int zSize;

    public MinesweeperGameEntry(JsonObject object) {
        super(object);
        this.uuid = UUID.fromString(object.get("uuid").getAsString());
        this.type = Type.valueOf(object.get("type").getAsString());
        this.time = object.get("time").getAsInt();
        this.timestamp = object.get("timestamp").getAsString();
        this.generator = Generator.valueOf(object.get("generator").getAsString());
        if (!object.get("gameData").isJsonNull()) this.gameData = object.get("gameData").getAsString();
        this.saveField = object.get("saveField").getAsString();
        this.mines = object.get("mines").getAsInt();
        this.correctFlags = object.get("correctFlags").getAsInt();
        this.incorrectFlags = object.get("incorrectFlags").getAsInt();
        this.won = object.get("won").getAsBoolean();
        this.xSize = object.get("xsize").getAsInt();
        this.zSize = object.get("zsize").getAsInt();
    }
}