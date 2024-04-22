package de.jjjannik.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * This enum represents all api datasets containing <b>only</b> the two same url requests for getting player stats and getting top players of the mode.
 */
@Getter
@RequiredArgsConstructor
public enum Standard {
    BEDWARS("bedwars"),
    BOW_SPLEEF("bowspleef"),
    CORES("cores"),
    FASTBRIDGE_INCLINED("fastbridge_inclined"),
    FASTBRIDGE_INCLINED_SHORT("fastbridge_inclined_short"),
    FASTBRIDGE_NORMAL("fastbridge"),
    FASTBRIDGE_SHORT("fastbridge_short"),
    FASTBRIDGE_EXTRA_SHORT("fastbridge_extra_short"),
    FASTBRIDGE_STAIRCASE("fastbridge_staircase"),
    JUMP_LEAGUE("jumpleague"),
    KNOCKFFA("knockffa"),
    LOGIN_STREAK("loginstreak"),
    ONE_LINE("oneline"),
    ONE_VS_ONE("1vs1"),
    PLAYER_PERFORMANCE("performance"),
    QSG("qsg"),
    QUAKE("quake"),
    RUSH("rush"),
    SKYWARS("skywars"),
    SNOWBALL_FIGHT("snowballfight"),
    SPLEEF("spleef"),
    SUMO("sumo"),
    TNT_RUN("tntrun"),
    TOKENS("tokens"),
    UHC("uhc");

    private final String requestName;

    public String getTopURL() {
        return String.format("https://api.greev.eu/v2/stats/%s/top?amount=%s&offset=%s", this.getRequestName(), "%s", "%s");
    }

    public String getPlayerURL() {
        return String.format("https://api.greev.eu/v2/stats/%s/player/%s", this.getRequestName(), "%s");
    }
}