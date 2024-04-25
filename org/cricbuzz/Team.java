package org.cricbuzz;

import java.util.List;

public class Team {
    String name;
    List<Player> playerList_;
    BattingController battingController_;
    BowlingController bowlingController_;
    int wickets;

    public void rotateStrike() {
    }

    public Player getStriker() {
        return null;
    }

    public Player getCurrentBowler() {
        return null;
    }

    public void chooseNextBatsMan() {
    }

    public int getTotalRuns() {
        return 0;

    }
}
