package de.jjjannik.entities.playerstats;

import com.google.gson.JsonObject;
import de.jjjannik.entities.basic.DataEntity;
import lombok.Getter;

@Getter
public class PlayerStatsLoginstreak extends DataEntity {
    private final int maxLoginStreak;
    private final int currentLoginStreak;

    public PlayerStatsLoginstreak(JsonObject object) {
        super(object);
        this.maxLoginStreak = object.get("maxLoginStreak").getAsInt();
        this.currentLoginStreak = object.get("currentLoginStreak").getAsInt();
    }
}