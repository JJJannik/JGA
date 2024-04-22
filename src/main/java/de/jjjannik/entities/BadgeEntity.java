package de.jjjannik.entities;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.DataEntity;
import lombok.Getter;

@Getter
public class BadgeEntity extends DataEntity {
    private final int id;
    private final String name;
    private final String description;
    private final String item;
    private final String timestamp;

    public BadgeEntity(JsonObject object) {
        super(object);
        this.id = object.get("id").getAsInt();
        this.name = object.get("name").getAsString();
        this.description = object.get("description").getAsString();
        this.item = object.get("item").getAsString();
        this.timestamp = object.get("timestamp").getAsString();
    }
}