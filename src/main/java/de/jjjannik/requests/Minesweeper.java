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

    public static String generateOptionalArgsString(Integer amount, Integer offset, Mode mode, RankingCriteria criteria, Generator generator, Long start, Long end) {
        StringBuilder arg = new StringBuilder();
        if (amount != null) {
            arg.append("amount=").append(amount);
        }
        if (offset != null) {
            arg.append("&offset=").append(offset);
        }
        if (mode != null) {
            arg.append("&mode=").append(mode);
        }
        if (criteria != null) {
            arg.append("&criteria=").append(criteria);
        }
        if (generator != null) {
            arg.append("&generator=").append(generator);
        }
        if (start != null) {
            arg.append("&start=").append(start);
        }
        if (end != null) {
            arg.append("&end=").append(end);
        }
        return arg.toString();
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