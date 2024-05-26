package de.jjjannik.entities.playerstats;

import com.google.gson.JsonObject;
import de.jjjannik.entities.ClanPlayer;
import de.jjjannik.entities.basic.Player;
import lombok.Getter;

@Getter
public class PlayerMetaEntity extends Player {
    private final long lastOnline;
    private final long firstOnline;
    private final ClanPlayer clanPlayer;
    private final PlayerRank playerRank;

    public PlayerMetaEntity(JsonObject object) {
        super(object);
        this.lastOnline = object.get("lastOnline").getAsLong();
        this.firstOnline = object.get("firstOnline").getAsLong();
        this.clanPlayer = object.get("clan") == null ? null : new ClanPlayer(object.get("clan").getAsJsonObject());
        this.playerRank = new PlayerRank(object.get("rank").getAsJsonObject());
    }
}