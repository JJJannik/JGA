package de.jjjannik.entities.playerstats;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.DataEntity;
import lombok.Getter;

@Getter
public class PlayerRank extends DataEntity {
    private final String name;
    private final long until;

    public PlayerRank(JsonObject object) {
        super(object);
        this.name = object.get("name").getAsString();
        this.until = object.get("until").getAsLong();
    }
}