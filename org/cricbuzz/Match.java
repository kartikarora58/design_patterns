package org.cricbuzz;

import java.time.LocalDateTime;
import java.util.List;

public class Match {
    Team first;
    Team second;
    String stadiumName;
    LocalDateTime startTime;
    List<Inning> innings;
    Team tossWinner;
    Team winner;
    MatchStatus matchStatus_;
    Match(Team first,Team second,String stadiumName,LocalDateTime startTime)
    {
        this.first = first;
        this.second = second;
        this.stadiumName = stadiumName;
        this.startTime = startTime;
    }

    public void startMatch()
    {

    }

    public void setMatchStatus(MatchStatus matchStatus) {
    }

    public void setWinner(Team batting) {
    }
}
