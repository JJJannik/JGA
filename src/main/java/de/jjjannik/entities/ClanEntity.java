package de.jjjannik.entities;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.DataEntity;
import lombok.Getter;

@Getter
public class ClanEntity extends DataEntity {
    private final String name;
    private final String tag;
    private final int size;
    private final float playerPerformance;
    private final int id;

    public ClanEntity(JsonObject object) {
        super(object);
        this.name = object.get("name").getAsString();
        this.tag = object.get("tag").getAsString();
        this.size = object.get("size").getAsInt();
        this.playerPerformance = object.get("playerperformance").getAsFloat();
        this.id = object.get("id").getAsInt();
    }
}