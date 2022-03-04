package com.obj;

import java.util.ArrayList;

public class Match {

    private int matchCode;
    private TeamScore homeTeam;
    private TeamScore awayTeam;

    public int getMatchCode() {
        return matchCode;
    }

    public void setMatchCode(int matchCode) {
        this.matchCode = matchCode;
    }

    public TeamScore getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(TeamScore homeTeam) {
        this.homeTeam = homeTeam;
    }

    public TeamScore getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(TeamScore awayTeam) {
        this.awayTeam = awayTeam;
    }
}
