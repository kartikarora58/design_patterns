package org.cricbuzzv2;

import org.cricbuzz.Team;

import java.util.Random;

public class Match {
    Team first;
    Team second;
    Inning[] innings;
    MatchType matchType_;
    int overs;
    Team winner;


    public void startMatch()
    {

    }
    public String tossCoin()
    {
        Random random = new Random();
        if((random.nextInt(2) & 1) == 1)
            return "heads";
        return "tails";
    }


}
