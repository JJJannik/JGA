package de.jjjannik.entities;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.DataEntity;
import lombok.Getter;

@Getter
public class NameHistoryEntry extends DataEntity {
    private final String name;
    private final long changedToAt;

    public NameHistoryEntry(JsonObject object) {
        super(object);
        this.name = object.get("name").getAsString();
        this.changedToAt = object.get("changedToAt").getAsLong();
    }
}