package de.jjjannik.entities.playerstats;

import com.google.gson.JsonObject;
import lombok.Getter;

@Getter
public class PlayerStatsEntity extends PlayerMetaEntity {
    private final int tokens;
    private final float playerPerformance;
    private final PlayerStatsLoginstreak loginstreak;
    private final PlayerMinigameStats playerMinigameStats;

    public PlayerStatsEntity(JsonObject object) {
        super(object);
        this.tokens = object.get("tokens").getAsInt();
        this.playerPerformance = object.get("playerperformance").getAsFloat();
        this.loginstreak = new PlayerStatsLoginstreak(object.get("loginstreak").getAsJsonObject());
        this.playerMinigameStats = new PlayerMinigameStats(object.get("stats").getAsJsonObject());
    }
}