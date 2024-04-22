package de.jjjannik.entities.basic;

import com.google.gson.JsonObject;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Represents parent for all Player entities containing uuid and name
 */
@Getter
public class Player extends DataEntity {
    /**
     * Variable name can be null if it returns an inheriting minigame entity (e.g. BedwarsPlayer) contained the {@code JGA.getAllPlayerStats()}
     */
    @Nullable private final String name;
    private final UUID uuid;

    public Player(JsonObject object) {
        super(object);
        this.name = object.get("name") == null ? null : object.get("name").getAsString();
        this.uuid = UUID.fromString(object.get("uuid").getAsString());
    }
}