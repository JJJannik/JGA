package de.jjjannik.entities.playerstats;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.jjjannik.entities.*;
import de.jjjannik.entities.basic.DataEntity;
import de.jjjannik.entities.basic.KillsDeathsPlayer;
import de.jjjannik.entities.basic.PvPPlayer;
import de.jjjannik.entities.basic.WinsLosesPlayer;
import de.jjjannik.entities.fastbridge.FastBridgePlayer;
import de.jjjannik.entities.minesweeper.MinesweeperTimePlayer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PlayerMinigameStats extends DataEntity {
    private final BedwarsPlayer bedwarsPlayer;
    private final WinsLosesPlayer bowspleefPlayer;
    private final KillsDeathsPlayer knockffaPlayer;
    private final KillsDeathsPlayer knockPvPPlayer;
    private final MLGRushPlayer mlgRushPlayer;
    private final CoresPlayer coresPlayer;
    private final KillsDeathsPlayer onelinePlayer;
    private final KillsDeathsPlayer oneVsOnePlayer;
    private final PvPPlayer qsgPlayer;
    private final PvPPlayer quakePlayer;
    private final RushPlayer rushPlayer;
    private final PvPPlayer skywarsPlayer;
    private final KillsDeathsPlayer snowballFightPlayer;
    private final WinsLosesPlayer spleefPlayer;
    private final KillsDeathsPlayer sumoPlayer;
    private final WinsLosesPlayer tntRunPlayer;
    private final PvPPlayer uhcPlayer;
    private final List<FastBridgePlayer> fastBridgePlayer = new ArrayList<>();
    private final List<MinesweeperTimePlayer> minesweeperPlayer = new ArrayList<>();
    private final List<BadgeEntity> badges = new ArrayList<>();

    public PlayerMinigameStats(JsonObject object) {
        super(object);
        this.bedwarsPlayer = object.get("bedwars") == null ? null : new BedwarsPlayer(object.get("bedwars").getAsJsonObject());
        this.bowspleefPlayer = object.get("bowspleef") == null ? null : new WinsLosesPlayer(object.get("bowspleef").getAsJsonObject());
        this.knockffaPlayer = object.get("knockFfa") == null ? null : new KillsDeathsPlayer(object.get("knockFfa").getAsJsonObject());
        this.knockPvPPlayer = object.get("knockPvp") == null ? null : new KillsDeathsPlayer(object.get("knockPvp").getAsJsonObject());
        this.mlgRushPlayer = object.get("mlgrush") == null ? null : new MLGRushPlayer(object.get("mlgrush").getAsJsonObject());
        this.coresPlayer = object.get("cores") == null ? null : new CoresPlayer(object.get("cores").getAsJsonObject());
        this.onelinePlayer = object.get("oneline") == null ? null : new KillsDeathsPlayer(object.get("oneline").getAsJsonObject());
        this.oneVsOnePlayer = object.get("oneVsOne") == null ? null : new KillsDeathsPlayer(object.get("oneVsOne").getAsJsonObject());
        this.qsgPlayer = object.get("qsg") == null ? null : new PvPPlayer(object.get("qsg").getAsJsonObject());
        this.quakePlayer = object.get("quake") == null ? null : new PvPPlayer(object.get("quake").getAsJsonObject());
        this.rushPlayer = object.get("rush") == null ? null : new RushPlayer(object.get("rush").getAsJsonObject());
        this.skywarsPlayer = object.get("skywars") == null ? null : new PvPPlayer(object.get("skywars").getAsJsonObject());
        this.snowballFightPlayer = object.get("snowballFight") == null ? null : new KillsDeathsPlayer(object.get("snowballFight").getAsJsonObject());
        this.spleefPlayer = object.get("spleef") == null ? null : new WinsLosesPlayer(object.get("spleef").getAsJsonObject());
        this.sumoPlayer = object.get("sumo") == null ? null : new KillsDeathsPlayer(object.get("sumo").getAsJsonObject());
        this.tntRunPlayer = object.get("tntrun") == null ? null : new WinsLosesPlayer(object.get("tntrun").getAsJsonObject());
        this.uhcPlayer = object.get("uhc") == null ? null : new PvPPlayer(object.get("uhc").getAsJsonObject());

        object.get("fastbridge").getAsJsonArray().asList().stream().map(JsonElement::getAsJsonObject).forEachOrdered(o -> this.fastBridgePlayer.add(new FastBridgePlayer(o)));
        object.get("minesweeper").getAsJsonArray().asList().stream().map(JsonElement::getAsJsonObject).forEachOrdered(o -> this.minesweeperPlayer.add(new MinesweeperTimePlayer(o)));
        object.get("badges").getAsJsonArray().asList().stream().map(JsonElement::getAsJsonObject).forEachOrdered(o -> this.badges.add(new BadgeEntity(o)));
    }
}