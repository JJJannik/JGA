package de.jjjannik.entities;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.DataEntity;
import lombok.Getter;

@Getter
public class ClanPlayer extends DataEntity {
    private final String name;
    private final String tag;
    private final int size;
    private final String role;

    public ClanPlayer(JsonObject object) {
        super(object);
        this.name = object.get("name").getAsString();
        this.tag = object.get("tag").getAsString();
        this.size = object.get("size").getAsInt();
        this.role = object.get("role").getAsString();
    }
}