package org.cricbuzz;

import java.util.List;

public class Inning {

    Team bowling;
    Team batting;
    List<Over> overs;

    Inning(Team bowling,Team batting)
    {
        this.bowling = bowling;
        this.batting = batting;
    }

    public void startInnings(int targetScore, int numberOfOvers,Match match)
    {
        for(int i=0;i<numberOfOvers;i++)
        {
            Over over = new Over(i+1);
            over.startOver(batting,bowling,targetScore,match);
            if(match.matchStatus_==MatchStatus.END)
                return;
            batting.rotateStrike();
        }
    }
}
