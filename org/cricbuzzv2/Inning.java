package org.cricbuzzv2;

import java.util.List;

public class Inning {
    Team battingTeam;
    Team bowlingTeam;
    int totalRuns;
    int totalWickets;
    InningStatus inningStatus_;  //(IN_PROGRESS,END)

    List<Over> overList_;
    int overs;
    int targetScore;

    public void startInnings()
    {

    }


}
