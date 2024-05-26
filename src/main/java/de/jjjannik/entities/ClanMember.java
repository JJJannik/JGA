package de.jjjannik.entities;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.DataEntity;
import lombok.Getter;

@Getter
public class ClanMember extends DataEntity {
    private final String name;
    private final boolean isLeader;

    public ClanMember(JsonObject jsonObject) {
        super(jsonObject);
        this.name = jsonObject.get("name").getAsString();
        this.isLeader = jsonObject.get("type").getAsBoolean();
    }
}