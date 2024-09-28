package de.jjjannik.api.impl;

import de.jjjannik.api.JGA;
import de.jjjannik.entities.*;
import de.jjjannik.entities.basic.KillsDeathsPlayer;
import de.jjjannik.entities.basic.Player;
import de.jjjannik.entities.basic.PvPPlayer;
import de.jjjannik.entities.basic.WinsLosesPlayer;
import de.jjjannik.entities.fastbridge.FastBridgeIslandsPlayer;
import de.jjjannik.entities.fastbridge.FastBridgePlayer;
import de.jjjannik.entities.jumpnrun.JumpNRunPlayer;
import de.jjjannik.entities.jumpnrun.JumpNRunTime;
import de.jjjannik.entities.minesweeper.*;
import de.jjjannik.entities.playerstats.PlayerMetaEntity;
import de.jjjannik.entities.playerstats.PlayerStatsEntity;
import de.jjjannik.requests.*;
import de.jjjannik.requests.Minesweeper.Generator;
import de.jjjannik.requests.Minesweeper.Mode;
import de.jjjannik.requests.Minesweeper.RankingCriteria;
import de.jjjannik.requests.Minesweeper.Type;
import de.jjjannik.utils.web.RequestManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class JGAImpl implements JGA {
    private final RequestManager manager = new RequestManager();

    @Override
    public PlayerMetaEntity getPlayerMetaData(UUID uuid) {
        return new PlayerMetaEntity(manager.requestData(PlayerMetadata.GET_DATA.getUrl().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<BadgeEntity> getPlayerBadges(UUID uuid) {
        return manager.requestData(Badges.GET_PLAYER.getUrl().formatted(uuid))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new BadgeEntity(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public Player getPlayerUUID(String name) {
        return new Player(manager.requestData(NamesAndUUIDs.GET_UUID.getUrl().formatted(name)).getAsJsonObject());
    }

    @Override
    public Player getPlayerName(UUID uuid) {
        return new Player(manager.requestData(NamesAndUUIDs.GET_NAME.getUrl().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<NameHistoryEntry> getNameHistory(UUID uuid) {
        return manager.requestData(NamesAndUUIDs.GET_NAME_HISTORY.getUrl().formatted(uuid))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new NameHistoryEntry(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public List<PerformancePlayer> getTopPerformance(int amount, int offset) {
        return manager.requestData(Standard.PLAYER_PERFORMANCE.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new PerformancePlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public PerformancePlayer getPerformancePlayer(UUID uuid) {
        return new PerformancePlayer(manager.requestData(Standard.PLAYER_PERFORMANCE.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<TokensPlayer> getTopTokens(int amount, int offset) {
        return manager.requestData(Standard.TOKENS.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new TokensPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public TokensPlayer getTokensPlayer(UUID uuid) {
        return new TokensPlayer(manager.requestData(Standard.TOKENS.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public LoginstreakPlayer getLoginstreakPlayer(UUID uuid) {
        return new LoginstreakPlayer(manager.requestData(Standard.LOGIN_STREAK.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<LoginstreakPlayer> getTopLoginstreak(int amount, int offset) {
        return manager.requestData(Standard.LOGIN_STREAK.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new LoginstreakPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public PlayerStatsEntity getAllPlayerStats(UUID uuid) {
        return new PlayerStatsEntity(manager.requestData(PlayerStats.GET_ALL_STATS.getUrl().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public ClanEntity getClan(String clanName) {
        return new ClanEntity(manager.requestData(Clans.GET_DETAILS.getUrl().formatted(clanName)).getAsJsonObject());
    }

    @Override
    public List<ClanEntity> getTopClans(int amount, int offset) {
        return manager.requestData(Clans.GET_TOP.getUrl().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new ClanEntity(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public List<ClanMember> getClanMembers(String clanName) {
        return manager.requestData(Clans.GET_MEMBERS.getUrl().formatted(clanName))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new ClanMember(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public List<PvPPlayer> getTopQsg(int amount, int offset) {
        return manager.requestData(Standard.QSG.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new PvPPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public PvPPlayer getQsgPlayer(UUID uuid) {
        return new PvPPlayer(manager.requestData(Standard.QSG.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<KillsDeathsPlayer> getTopOneline(int amount, int offset) {
        return manager.requestData(Standard.ONE_LINE.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new KillsDeathsPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public KillsDeathsPlayer getOnelinePlayer(UUID uuid) {
        return new KillsDeathsPlayer(manager.requestData(Standard.ONE_LINE.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<KillsDeathsPlayer> getTopSumo(int amount, int offset) {
        return manager.requestData(Standard.SUMO.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new KillsDeathsPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public KillsDeathsPlayer getSumoPlayer(UUID uuid) {
        return new KillsDeathsPlayer(manager.requestData(Standard.SUMO.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<KillsDeathsPlayer> getTopKnockFFA(int amount, int offset) {
        return manager.requestData(Standard.KNOCKFFA.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new KillsDeathsPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public KillsDeathsPlayer getKnockFFAPlayer(UUID uuid) {
        return new KillsDeathsPlayer(manager.requestData(Standard.KNOCKFFA.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<PvPPlayer> getTopSkywars(int amount, int offset) {
        return manager.requestData(Standard.SKYWARS.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new PvPPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public PvPPlayer getSkywarsPlayer(UUID uuid) {
        return new PvPPlayer(manager.requestData(Standard.SKYWARS.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<KillsDeathsPlayer> getTopSnowballFight(int amount, int offset) {
        return manager.requestData(Standard.SNOWBALL_FIGHT.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new KillsDeathsPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public KillsDeathsPlayer getSnowballFightPlayer(UUID uuid) {
        return new KillsDeathsPlayer(manager.requestData(Standard.SNOWBALL_FIGHT.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<PvPPlayer> getTopUHC(int amount, int offset) {
        return manager.requestData(Standard.UHC.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new PvPPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public PvPPlayer getUHCPlayer(UUID uuid) {
        return new PvPPlayer(manager.requestData(Standard.UHC.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<WinsLosesPlayer> getTopBowSpleef(int amount, int offset) {
        return manager.requestData(Standard.BOW_SPLEEF.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new WinsLosesPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public WinsLosesPlayer getBowSpleefPlayer(UUID uuid) {
        return new WinsLosesPlayer(manager.requestData(Standard.BOW_SPLEEF.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<PvPPlayer> getTopJumpLeague(int amount, int offset) {
        return manager.requestData(Standard.JUMP_LEAGUE.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new PvPPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public PvPPlayer getJumpLeaguePlayer(UUID uuid) {
        return new PvPPlayer(manager.requestData(Standard.JUMP_LEAGUE.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<WinsLosesPlayer> getTopTnTRun(int amount, int offset) {
        return manager.requestData(Standard.TNT_RUN.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new WinsLosesPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public WinsLosesPlayer getTnTRunPlayer(UUID uuid) {
        return new WinsLosesPlayer(manager.requestData(Standard.TNT_RUN.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<BedwarsPlayer> getTopBedwars(int amount, int offset) {
        return manager.requestData(Standard.BEDWARS.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new BedwarsPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public BedwarsPlayer getBedwarsPlayer(UUID uuid) {
        return new BedwarsPlayer(manager.requestData(Standard.BEDWARS.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<CoresPlayer> getTopCores(int amount, int offset) {
        return manager.requestData(Standard.CORES.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new CoresPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public CoresPlayer getCoresPlayer(UUID uuid) {
        return new CoresPlayer(manager.requestData(Standard.CORES.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<WinsLosesPlayer> getTopSpleef(int amount, int offset) {
        return manager.requestData(Standard.SPLEEF.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new WinsLosesPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public WinsLosesPlayer getSpleefPlayer(UUID uuid) {
        return new WinsLosesPlayer(manager.requestData(Standard.SPLEEF.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<PvPPlayer> getTopQuake(int amount, int offset) {
        return manager.requestData(Standard.QUAKE.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new PvPPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public PvPPlayer getQuakePlayer(UUID uuid) {
        return new PvPPlayer(manager.requestData(Standard.QUAKE.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<KillsDeathsPlayer> getTop1vs1(int amount, int offset) {
        return manager.requestData(Standard.ONE_VS_ONE.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new KillsDeathsPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public KillsDeathsPlayer get1vs1Player(UUID uuid) {
        return new KillsDeathsPlayer(manager.requestData(Standard.ONE_VS_ONE.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<RushPlayer> getTopRush(int amount, int offset) {
        return manager.requestData(Standard.RUSH.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new RushPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public RushPlayer getRushPlayer(UUID uuid) {
        return new RushPlayer(manager.requestData(Standard.RUSH.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<FastBridgePlayer> getTopFastbridge(int amount, int offset) {
        return manager.requestData(Standard.FASTBRIDGE_NORMAL.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new FastBridgePlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public FastBridgePlayer getFastbridgePlayer(UUID uuid) {
        return new FastBridgePlayer(manager.requestData(Standard.FASTBRIDGE_NORMAL.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<FastBridgePlayer> getTopFastbridgeStaircase(int amount, int offset) {
        return manager.requestData(Standard.FASTBRIDGE_STAIRCASE.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new FastBridgePlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public FastBridgePlayer getFastbridgeStaircasePlayer(UUID uuid) {
        return new FastBridgePlayer(manager.requestData(Standard.FASTBRIDGE_STAIRCASE.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<FastBridgePlayer> getTopFastbridgeShort(int amount, int offset) {
        return manager.requestData(Standard.FASTBRIDGE_SHORT.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new FastBridgePlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public FastBridgePlayer getFastbridgeShortPlayer(UUID uuid) {
        return new FastBridgePlayer(manager.requestData(Standard.FASTBRIDGE_SHORT.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<FastBridgePlayer> getTopFastbridgeExtraShort(int amount, int offset) {
        return manager.requestData(Standard.FASTBRIDGE_EXTRA_SHORT.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new FastBridgePlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public FastBridgePlayer getFastbridgeExtraShortPlayer(UUID uuid) {
        return new FastBridgePlayer(manager.requestData(Standard.FASTBRIDGE_EXTRA_SHORT.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<FastBridgeIslandsPlayer> getTopFastbridgeIslands(FastbridgeIslands.Map map, int amount, int offset) {
        return manager.requestData(FastbridgeIslands.GET_TOP.getUrl().formatted(map, amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new FastBridgeIslandsPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public List<FastBridgeIslandsPlayer> getFastbridgeIslandsPlayer(UUID uuid) {
        return manager.requestData(FastbridgeIslands.GET_PLAYER.getUrl().formatted(uuid))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new FastBridgeIslandsPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public List<FastBridgePlayer> getTopFastbridgeInclined(int amount, int offset) {
        return manager.requestData(Standard.FASTBRIDGE_INCLINED.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new FastBridgePlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public FastBridgePlayer getFastbridgeInclinedPlayer(UUID uuid) {
        return new FastBridgePlayer(manager.requestData(Standard.FASTBRIDGE_INCLINED.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<FastBridgePlayer> getTopFastbridgeInclinedShort(int amount, int offset) {
        return manager.requestData(Standard.FASTBRIDGE_INCLINED_SHORT.getTopURL().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new FastBridgePlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public FastBridgePlayer getFastbridgeInclinedShortPlayer(UUID uuid) {
        return new FastBridgePlayer(manager.requestData(Standard.FASTBRIDGE_INCLINED_SHORT.getPlayerURL().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<MLGRushPlayer> getTopMLGRush(int amount, int offset) {
        return manager.requestData(MLGRush.GET_TOP.getUrl().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new MLGRushPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public List<MLGRushPlayer> getRollingTopMLGRush(int amount, int offset, long startTimestamp, long endTimestamp) {
        return manager.requestData(MLGRush.GET_ROLLING_TOP.getUrl().formatted(amount, offset, startTimestamp, endTimestamp))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new MLGRushPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public MLGRushPlayer getRollingMLGRushPlayer(UUID uuid, long startTimestamp, long endTimestamp) {
        return new MLGRushPlayer(manager.requestData(MLGRush.GET_ROLLING_PLAYER.getUrl().formatted(uuid, startTimestamp, endTimestamp)).getAsJsonObject());
    }

    @Override
    public MLGRushPlayer getMLGRushPlayer(UUID uuid) {
        return new MLGRushPlayer(manager.requestData(MLGRush.GET_PLAYER.getUrl().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<KnockPVPPlayer> getTopKnockPvP(int amount, int offset) {
        return manager.requestData(KnockPVP.GET_TOP.getUrl().formatted(amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new KnockPVPPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public List<KillsDeathsPlayer> getRollingTopKnockPvP(int amount, int offset, long startTimestamp, long endTimestamp) {
        return manager.requestData(KnockPVP.GET_ROLLING_TOP.getUrl().formatted(amount, offset, startTimestamp, endTimestamp))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new KillsDeathsPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public KillsDeathsPlayer getRollingKnockPvPPlayer(UUID uuid, long startTimestamp, long endTimestamp) {
        return new KillsDeathsPlayer(manager.requestData(KnockPVP.GET_ROLLING_PLAYER.getUrl().formatted(uuid, startTimestamp, endTimestamp)).getAsJsonObject());
    }

    @Override
    public KnockPVPPlayer getKnockPvPPlayer(UUID uuid) {
        return new KnockPVPPlayer(manager.requestData(KnockPVP.GET_PLAYER.getUrl().formatted(uuid)).getAsJsonObject());
    }

    @Override
    public List<KillsDeathsPlayer> getTopKnockPvPLab(String experiment, int amount, int offset) {
        return manager.requestData(KnockPVPLab.GET_TOP.getUrl().formatted(experiment, amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new KillsDeathsPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public List<KillsDeathsPlayer> getRollingTopKnockPvPLab(String experiment, int amount, int offset, long startTimestamp, long endTimestamp) {
        return manager.requestData(KnockPVPLab.GET_ROLLING_TOP.getUrl().formatted(experiment, amount, offset, startTimestamp, endTimestamp))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new KillsDeathsPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public KillsDeathsPlayer getRollingKnockPvPLabPlayer(UUID uuid, String experiment, long startTimestamp, long endTimestamp) {
        return new KillsDeathsPlayer(manager.requestData(KnockPVPLab.GET_ROLLING_PLAYER.getUrl().formatted(uuid, experiment, startTimestamp, endTimestamp)).getAsJsonObject());
    }

    @Override
    public KillsDeathsPlayer getKnockPvPLabPlayer(UUID uuid, String experiment) {
        return new KillsDeathsPlayer(manager.requestData(KnockPVPLab.GET_PLAYER.getUrl().formatted(uuid, experiment)).getAsJsonObject());
    }

    @Override
    public List<MinesweeperTopEntry> getTopMinesweeperTimes(@Nullable Integer amount, @Nullable Integer offset, @Nullable Mode mode, @Nullable RankingCriteria criteria, @Nullable Long startTimestamp, @Nullable Long endTimestamp, @NotNull Type type, @NotNull Generator generator) {
        return manager.requestData(Minesweeper.GET_TOP.getUrl()
                        .formatted(type, generator, Minesweeper.generateOptionalArgsString(amount, offset, null, mode, criteria, null, startTimestamp, endTimestamp)))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new MinesweeperTopEntry(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public List<MinesweeperTimePlayer> getBestMinesweeperTimes(UUID uuid, @Nullable Mode mode) {
        return manager.requestData(Minesweeper.GET_PLAYER_TIME.getUrl().formatted(uuid, mode == null ? "" : mode))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new MinesweeperTimePlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public MinesweeperBestPlayer getFilteredBestMinesweeperTime(UUID uuid, @NotNull Type type, @NotNull Generator generator, @Nullable Mode mode) {
        return new MinesweeperBestPlayer(manager.requestData(Minesweeper.GET_PLAYER_TIME_SPECIFIC.getUrl()
                .formatted(uuid, type, generator, mode == null ? "" : mode)).getAsJsonObject());
    }

    @Override
    public MinesweeperPlayer getMinesweeperPlayer(UUID uuid, @Nullable Type type, @Nullable Generator generator, @Nullable Mode mode, Long startTimestamp, Long endTimestamp) {
        return new MinesweeperPlayer(manager.requestData(Minesweeper.GET_OVERALL.getUrl()
                .formatted(uuid, Minesweeper.generateOptionalArgsString(null, null, type, mode, null, generator, startTimestamp, endTimestamp))).getAsJsonObject());
    }

    @Override
    public MinesweeperGameEntry getMinesweeperGameInfo(int id) {
        return new MinesweeperGameEntry(manager.requestData(Minesweeper.GET_GAME.getUrl().formatted(id)).getAsJsonObject());
    }

    @Override
    public List<JumpNRunPlayer> getTopJumpAndRun(int year, int id, int amount, int offset) {
        return manager.requestData(AdventJnRs.GET_TOP.getUrl().formatted(year, id, amount, offset))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new JumpNRunPlayer(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public List<JumpNRunTime> getYearPlayerAdventTimes(UUID uuid, int year) {
        return manager.requestData(AdventJnRs.GET_ALL_PLAYER.getUrl().formatted(uuid, year))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new JumpNRunTime(e.getAsJsonObject()))
                .toList();
    }

    @Override
    public List<JumpNRunTime> getDayPlayerAdventTimes(UUID uuid, int year, int day) {
        return manager.requestData(AdventJnRs.GET_ALL_PLAYER_DATE.getUrl().formatted(uuid, year, day))
                .getAsJsonArray()
                .asList()
                .stream()
                .map(e -> new JumpNRunTime(e.getAsJsonObject()))
                .toList();
    }
}