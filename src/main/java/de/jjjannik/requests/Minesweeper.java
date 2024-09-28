package de.jjjannik.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Minesweeper {
    GET_TOP("https://api.greev.eu/v2/stats/minesweeper/top/%s/%s?%s"), // last '%s' represents all possible other params
    GET_PLAYER_TIME("https://api.greev.eu/v2/stats/minesweeper/time/%s?mode=%s"),
    GET_PLAYER_TIME_SPECIFIC("https://api.greev.eu/v2/stats/minesweeper/time/%s/%s/%s?mode=%s"),
    GET_OVERALL("https://api.greev.eu/v2/stats/minesweeper/overall/%s?%s"), // last '%s' represents all possible other params
    GET_GAME("https://api.greev.eu/v2/stats/minesweeper/game/%s");

    private final String url;

    public static String generateOptionalArgsString(Integer amount, Integer offset, Type type, Mode mode, RankingCriteria criteria, Generator generator, Long start, Long end) {
        StringBuilder arg = new StringBuilder();
        boolean first = true;
        if (type != null) {
            arg.append(prefix(first)).append("type=").append(type);
            first = false;
        }
        if (amount != null) {
            arg.append(prefix(first)).append("amount=").append(amount);
            first = false;
        }
        if (offset != null) {
            arg.append(prefix(first)).append("offset=").append(offset);
            first = false;
        }
        if (mode != null) {
            arg.append(prefix(first)).append("mode=").append(mode);
            first = false;
        }
        if (criteria != null) {
            arg.append(prefix(first)).append("rankingCriteria=").append(criteria);
            first = false;
        }
        if (generator != null) {
            arg.append(prefix(first)).append("generator=").append(generator);
            first = false;
        }
        if (start != null) {
            arg.append(prefix(first)).append("start=").append(start);
            first = false;
        }
        if (end != null) {
            arg.append(prefix(first)).append("end=").append(end);
        }
        return arg.toString();
    }

    private static String prefix(boolean first) {
        return first ? "" : "&";
    }

    public enum Type {
        EASY,
        MEDIUM,
        HARD,
        EXTREME,
        HELL
    }

    public enum Generator {
        OG,
        GREEV,
        NO_GUESSING,
        SPEEDRUN
    }

    public enum Mode {
        DEFAULT,
        TRAINING,
        COUNTDOWN,
        COLOR
    }

    public enum RankingCriteria {
        TIME,
        MASTERY
    }
}