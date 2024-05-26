package de.jjjannik.api;

import de.jjjannik.entities.*;
import de.jjjannik.entities.basic.KillsDeathsPlayer;
import de.jjjannik.entities.basic.Player;
import de.jjjannik.entities.basic.PvPPlayer;
import de.jjjannik.entities.basic.WinsLosesPlayer;
import de.jjjannik.entities.jumpnrun.JumpNRunPlayer;
import de.jjjannik.entities.jumpnrun.JumpNRunTime;
import de.jjjannik.entities.minesweeper.*;
import de.jjjannik.entities.playerstats.PlayerMetaEntity;
import de.jjjannik.entities.playerstats.PlayerStatsEntity;
import de.jjjannik.requests.FastbridgeIslands;
import de.jjjannik.requests.Minesweeper.Generator;
import de.jjjannik.requests.Minesweeper.Mode;
import de.jjjannik.requests.Minesweeper.RankingCriteria;
import de.jjjannik.requests.Minesweeper.Type;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

/**
 * This interface represents the main access point for this API and contains all non-deprecated Greev API endpoints as of April 2024
 */
public interface JGA {
    // General methods

    /**
     * The all metadata for a specific player
     * @param uuid of the Player
     * @return a PlayerMetaEntity
     */
    PlayerMetaEntity getPlayerMetaData(UUID uuid);

    /**
     * Get all badges a player has
     * @param uuid of the Player
     * @return A list of all badges
     */
    List<BadgeEntity> getPlayerBadges(UUID uuid);

    /**
     * Get current uuid by name
     * @param name of the Player
     * @return a simple Player object with name and uuid
     */
    Player getPlayerUUID(String name);

    /**
     * Get current name by uuid
     * @param uuid of the Player
     * @return a simple Player object with name and uuid
     */
    Player getPlayerName(UUID uuid);

    /**
     * Get all name changes a player
     * @param uuid of the Player
     * @return A list of name changes
     */
    List<NameHistoryEntry> getNameHistory(UUID uuid);

    /**
     * Get top player stats for Playerperformance
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Performance player
     */
    List<PerformancePlayer> getTopPerformance(int amount, int offset);

    /**
     * Get player stats for Playerperformance
     * @param uuid of the Player
     * @return a PerformancePlayer object
     */
    PerformancePlayer getPerformancePlayer(UUID uuid);

    /**
     * Get top player stats for Tokens
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Tokens player
     */
    List<TokensPlayer> getTopTokens(int amount, int offset);

    /**
     * Get player stats for Tokens
     * @param uuid of the Player
     * @return a TokensPlayer object
     */
    TokensPlayer getTokensPlayer(UUID uuid);

    /**
     * Get player stats for Loginstreak
     * @param uuid of the player
     * @return a LoginstreakPlayer object
     */
    LoginstreakPlayer getLoginstreakPlayer(UUID uuid);

    /**
     * Get top player stats for Loginstreak
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Loginstreak player
     */
    List<LoginstreakPlayer> getTopLoginstreak(int amount, int offset);

    /**
     * Get all Minigames stats of a Player
     * @param uuid UUID of the Player
     * @return An PlayerStatsEntity object
     */
    PlayerStatsEntity getAllPlayerStats(UUID uuid);

    // Clan methods

    /**
     * Get stats for a specif clan
     * @param clanName of the clan
     * @return a ClanEntity object
     */
    ClanEntity getClan(String clanName);

    /**
     * Get top clans
     * @param amount of returned clans
     * @param offset of which place the API returns data
     * @return A list of the top clans
     */
    List<ClanEntity> getTopClans(int amount, int offset);

    /**
     * Get players of a clan
     * @param clanName of the clan
     * @return A list of Clan player
     */
    List<ClanMember> getClanMembers(String clanName);

    // Normal stats methods

    /**
     * Get top player stats for QSG
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top QSG player
     */
    List<PvPPlayer> getTopQsg(int amount, int offset);

    /**
     * Get player stats for QSG
     * @param uuid of the Player
     * @return a PvPPlayer object
     */
    PvPPlayer getQsgPlayer(UUID uuid);

    /**
     * Get top player stats for Oneline
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Oneline player
     */
    List<KillsDeathsPlayer> getTopOneline(int amount, int offset);

    /**
     * Get player stats for Oneline
     * @param uuid of the Player
     * @return a KillsDeathsPlayer object
     */
    KillsDeathsPlayer getOnelinePlayer(UUID uuid);

    /**
     * Get top player stats for Playerperformance
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Sumo player
     */
    List<KillsDeathsPlayer> getTopSumo(int amount, int offset);

    /**
     * Get player stats for Sumo
     * @param uuid of the Player
     * @return a KillsDeathsPlayer object
     */
    KillsDeathsPlayer getSumoPlayer(UUID uuid);

    /**
     * Get top player stats for KnockFFA
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top KnockFFA player
     */
    List<KillsDeathsPlayer> getTopKnockFFA(int amount, int offset);

    /**
     * Get player stats for KnockFFA
     * @param uuid of the Player
     * @return a KillsDeathsPlayer object
     */
    KillsDeathsPlayer getKnockFFAPlayer(UUID uuid);

    /**
     * Get top player stats for Skywars
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Skywars player
     */
    List<PvPPlayer> getTopSkywars(int amount, int offset);

    /**
     * Get player stats for Skywars
     * @param uuid of the Player
     * @return a PvPPlayer object
     */
    PvPPlayer getSkywarsPlayer(UUID uuid);

    /**
     * Get top player stats for Snowballfight
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top snowballfight player
     */
    List<KillsDeathsPlayer> getTopSnowballFight(int amount, int offset);

    /**
     * Get player stats for Snowballfight
     * @param uuid of the Player
     * @return a KillsDeathsPlayer object
     */
    KillsDeathsPlayer getSnowballFightPlayer(UUID uuid);

    /**
     * Get top player stats for UHC
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top UHC player
     */
    List<PvPPlayer> getTopUHC(int amount, int offset);

    /**
     * Get player stats for UHC
     * @param uuid of the Player
     * @return a KillsDeathsPlayer object
     */
    KillsDeathsPlayer getUHCPlayer(UUID uuid);

    /**
     * Get top player stats for Bowspleef
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top bowspleef player
     */
    List<WinsLosesPlayer> getTopBowSpleef(int amount, int offset);

    /**
     * Get player stats for Bowspleef
     * @param uuid of the Player
     * @return a WinsLosesPlayer object
     */
    WinsLosesPlayer getBowSpleefPlayer(UUID uuid);

    /**
     * Get top player stats for JumpLeague
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top JumpLeague player
     */
    List<PvPPlayer> getTopJumpLeague(int amount, int offset);

    /**
     * Get player stats for JumpLeague
     * @param uuid of the Player
     * @return a PvPPlayer object
     */
    PvPPlayer getJumpLeaguePlayer(UUID uuid);

    /**
     * Get top player stats for TnTRun
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top TnTRun player
     */
    List<WinsLosesPlayer> getTopTnTRun(int amount, int offset);

    /**
     * Get player stats for TNTRun
     * @param uuid of the Player
     * @return a WinsLosesPlayer object
     */
    WinsLosesPlayer getTnTRunPlayer(UUID uuid);

    /**
     * Get top player stats for Bedwars
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Bedwars player
     */
    List<BedwarsPlayer> getTopBedwars(int amount, int offset);

    /**
     * Get player stats for Bedwars
     * @param uuid of the Player
     * @return a BedwarsPlayer object
     */
    BedwarsPlayer getBedwarsPlayer(UUID uuid);

    /**
     * Get top player stats for Cores
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Cores player
     */
    List<CoresPlayer> getTopCores(int amount, int offset);

    /**
     * Get player stats for Cores
     * @param uuid of the Player
     * @return a CoresPlayer object
     */
    CoresPlayer getCoresPlayer(UUID uuid);

    /**
     * Get top player stats for Spleef
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Spleef player
     */
    List<WinsLosesPlayer> getTopSpleef(int amount, int offset);

    /**
     * Get player stats for Spleef
     * @param uuid of the Player
     * @return a WinsLosesPlayer object
     */
    WinsLosesPlayer getSpleefPlayer(UUID uuid);

    /**
     * Get top player stats for Quake
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Quake player
     */
    List<PvPPlayer> getTopQuake(int amount, int offset);

    /**
     * Get player stats for Quake
     * @param uuid of the Player
     * @return a PvPPlayer object
     */
    PvPPlayer getQuakePlayer(UUID uuid);

    /**
     * Get top player stats for 1vs1
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top 1vs1 player
     */
    List<PvPPlayer> getTop1vs1(int amount, int offset);

    /**
     * Get player stats for 1vs1
     * @param uuid of the Player
     * @return a KillsDeathsPlayer object
     */
    KillsDeathsPlayer get1v1Player(UUID uuid);

    /**
     * Get top player stats for Rush
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Rush player
     */
    List<RushPlayer> getTopRush(int amount, int offset);

    /**
     * Get player stats for Rush
     * @param uuid of the Player
     * @return a RushPlayer object
     */
    RushPlayer getRushPlayer(UUID uuid);

    // Fastbridge methods

    /**
     * Get top player stats for normal Fastbridge
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top normal Fastbridge player
     */
    List<FastBridgePlayer> getTopFastbridge(int amount, int offset);

    /**
     * Get player stats for Fastbridge
     * @param uuid of the Player
     * @return a FastbridgePlayer object
     */
    FastBridgePlayer getFastbridgePlayer(UUID uuid);

    /**
     * Get top player stats for Fastbridge Staircase
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Fastbridge Staircase player
     */
    List<FastBridgePlayer> getTopFastbridgeStaircase(int amount, int offset);

    /**
     * Get player stats for Fastbridge Staircase
     * @param uuid of the Player
     * @return a FastbridgePlayer object
     */
    FastBridgePlayer getFastbridgeStaircasePlayer(UUID uuid);

    /**
     * Get top player stats for Fastbridge Short
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Fastbridge Short player
     */
    List<FastBridgePlayer> getTopFastbridgeShort(int amount, int offset);

    /**
     * Get player stats for Fastbridge Short
     * @param uuid of the Player
     * @return a FastbridgePlayer object
     */
    FastBridgePlayer getFastbridgeShortPlayer(UUID uuid);


    /**
     * Get top player stats for Fastbridge Extra Short
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Fastbridge Extra Short player
     */
    List<FastBridgePlayer> getTopFastbridgeExtraShort(int amount, int offset);

    /**
     * Get player stats for Fastbridge Extra Short
     * @param uuid of the Player
     * @return a FastbridgePlayer object
     */
    FastBridgePlayer getFastbridgeExtraShortPlayer(UUID uuid);

    /**
     * Get top player stats for Fastbridge Island
     * @param map Fastbridge Islands map
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Fastbridge Staircase player
     */
    List<FastBridgePlayer> getTopFastbridgeIslands(FastbridgeIslands.Map map, int amount, int offset);

    /**
     * Get player stats for Fastbridge Islands
     * @param uuid of the Player
     * @return a FastbridgePlayer object
     */
    FastBridgePlayer getFastbridgeIslandsPlayer(UUID uuid);

    /**
     * Get top player stats for Fastbridge Inclined
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Fastbridge Inclined player
     */
    List<FastBridgePlayer> getTopFastbridgeInclined(int amount, int offset);

    /**
     * Get player stats for Fastbridge Inclined
     * @param uuid of the Player
     * @return a FastbridgePlayer object
     */
    FastBridgePlayer getFastbridgeInclinedPlayer(UUID uuid);

    /**
     * Get top player stats for Fastbridge Inclined Short
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top Fastbridge Inclined Short player
     */
    List<FastBridgePlayer> getTopFastbridgeInclinedShort(int amount, int offset);

    /**
     * Get player stats for Fastbridge Inclined Short
     * @param uuid of the Player
     * @return a FastbridgePlayer object
     */
    FastBridgePlayer getFastbridgeInclinedShortPlayer(UUID uuid);

    // MLGRush Methods

    /**
     * Get top player stats for MLGRush
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top MLGRush player
     */
    List<MLGRushPlayer> getTopMLGRush(int amount, int offset);

    /**
     * Get top rolling player stats for MLGRush
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @param startTimestamp starting timestamp of wanted period
     * @param endTimestamp ending timestamp of wanted period
     * @return A list of the top rolling MLGRush player
     */
    List<MLGRushPlayer> getRollingTopMLGRush(int amount, int offset, long startTimestamp, long endTimestamp);

    /**
     * Get rolling player stats for MLGRush
     * @param uuid of the Player
     * @param startTimestamp starting timestamp of wanted period
     * @param endTimestamp ending timestamp of wanted period
     * @return a MLGRushPlayer object
     */
    MLGRushPlayer getRollingMLGRushPlayer(UUID uuid, long startTimestamp, long endTimestamp);

    /**
     * Get player stats for MLGRush
     * @param uuid of the Player
     * @return a MLGRushPlayer object
     */
    MLGRushPlayer getMLGRushPlayer(UUID uuid);

    // KnockPVP methods

    /**
     * Get top player stats for KnockPvP
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top KnockPvP player
     */
    List<KillsDeathsPlayer> getTopKnockPvP(int amount, int offset);

    /**
     * Get top rolling player stats for KnockPvP
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @param startTimestamp starting timestamp of wanted period
     * @param endTimestamp ending timestamp of wanted period
     * @return A list of the top rolling KnockPvP player
     */
    List<KillsDeathsPlayer> getRollingTopKnockPvP(int amount, int offset, long startTimestamp, long endTimestamp);

    /**
     * Get rolling player stats for KnockPvP
     * @param uuid of the Player
     * @param startTimestamp starting timestamp of wanted period
     * @param endTimestamp ending timestamp of wanted period
     * @return a KillsDeathsPlayer object
     */
    KillsDeathsPlayer getRollingKnockPvPPlayer(UUID uuid, long startTimestamp, long endTimestamp);

    /**
     * Get player stats for KnockPvP
     * @param uuid of the Player
     * @return a KillsDeathsPlayer object
     */
    KillsDeathsPlayer getKnockPvPPlayer(UUID uuid);

    // KnockPvPLab

    /**
     * Get top player stats for KnockPvPLab
     * @param experiment Name of the lab experiment
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of the top KnockPvPLab player for specific experiment
     */
    List<KillsDeathsPlayer> getTopKnockPvPLab(String experiment, int amount, int offset);

    /**
     * Get top player stats for KnockPvPLab
     * @param experiment Name of the lab experiment
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @param startTimestamp starting timestamp of wanted period
     * @param endTimestamp ending timestamp of wanted period
     * @return A list of the top KnockPvPLab player for specific experiment
     */
    List<KillsDeathsPlayer> getRollingTopKnockPvPLab(String experiment, int amount, int offset, long startTimestamp, long endTimestamp);

    /**
     * Get rolling player stats for KnockPvPLab
     * @param uuid of the Player
     * @param experiment Name of the lab experiment
     * @param startTimestamp starting timestamp of wanted period
     * @param endTimestamp ending timestamp of wanted period
     * @return a KillsDeathsPlayer object
     */
    KillsDeathsPlayer getRollingKnockPvPLabPlayer(UUID uuid, String experiment, long startTimestamp, long endTimestamp);

    /**
     * Get player stats for KnockPvPLab
     * @param uuid of the Player
     * @param experiment Name of the lab experiment
     * @return A KillsDeathsPlayer object
     */
    KillsDeathsPlayer getKnockPvPLabPlayer(UUID uuid, String experiment);

    // Minesweeper methods

    /**
     * Get top times for Minesweeper filtered
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @param mode Minesweeper mode
     * @param criteria Minesweeper filter criteria
     * @param startTimestamp starting timestamp of wanted period
     * @param endTimestamp ending timestamp of wanted period
     * @param type Minesweeper difficulty
     * @param generator Minesweeper map generator
     * @return A list of the top Minesweeper times
     */
    List<MinesweeperTimeEntry> getTopMinesweeperTimes(@Nullable Integer amount, @Nullable Integer offset, @Nullable Mode mode, @Nullable RankingCriteria criteria, @Nullable Long startTimestamp, @Nullable Long endTimestamp, @NotNull Type type, @NotNull Generator generator);

    /**
     * Get top Minesweeper times of Player
     * @param uuid of Player
     * @param mode Minesweeper mode
     * @return A list of top Minesweeper time player
     */
    List<MinesweeperTimePlayer> getBestMinesweeperTimes(UUID uuid, @Nullable Mode mode);

    /**
     * Get top time for Minesweeper of Player
     * @param uuid UUID of the Player
     * @param mode Minesweeper mode
     * @param type Minesweeper difficulty
     * @param generator Minesweeper map generator
     * @return Best Minesweeper time of a player
     */
    MinesweeperBestPlayer getFilteredBestMinesweeperTime(UUID uuid, @NotNull Type type, @NotNull Generator generator, @Nullable Mode mode);

    /**
     * Get player stats for Minesweeper
     * @param uuid UUID of the Player
     * @param mode Minesweeper mode
     * @param type Minesweeper difficulty
     * @param generator Minesweeper map generator
     * @param startTimestamp starting timestamp of wanted period
     * @param endTimestamp ending timestamp of wanted period
     * @return A MinesweeperPlayer object
     */
    MinesweeperPlayer getMinesweeperPlayer(UUID uuid, @Nullable Type type, @Nullable Generator generator, @Nullable Mode mode, Long startTimestamp, Long endTimestamp);

    /**
     * Get Minesweeper game details
     * @param id Minesweeper game id
     * @return A MinesweeperGameEntry object
     */
    MinesweeperGameEntry getMinesweeperGameInfo(int id);

    // Advent JumpAndRuns

    /**
     * Get top Advent Jump and Run's of specific date on year
     * @param year of the advent
     * @param id day of advent calendar
     * @param amount of returned player
     * @param offset of which place the API returns data
     * @return A list of top Player on Advents Day Jump and Run
     */
    List<JumpNRunPlayer> getTopJumpAndRun(int year, int id, @Nullable Integer amount, @Nullable Integer offset);

    /**
     * Get Jump and Run times of a Player of a year
     * @param uuid of the Player
     * @param year of the Advent event
     * @return A list of Jump and Run Times
     */
    List<JumpNRunTime> getAllPlayerJumpAndRunTimes(UUID uuid, int year);

    /**
     * Get Jump and Run times of a Player of a specific date
     * @param uuid of the Player
     * @param year of the Advent event
     * @param id of the Advent date
     * @return A list of Jump and Run Times
     */
    List<JumpNRunTime> getAllPlayerJumpAndRunTimes(UUID uuid, int year, int id);
}