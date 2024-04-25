package org.cricbuzz;

import java.util.List;

public class Ball {
    int ballNumber;
    Player bowler;
    Player batsman;
    int runs;
    BallType ballTye_;
    List<ScoreUpdater> scoreUpdaterList_;
    Ball(int ballNumber,Player bowler, Player batsman)
    {
        this.ballNumber = ballNumber;
        this.bowler = bowler;
        this.batsman = batsman;
    }

    public void throwBall()
    {
        int ballTypeindex = Util.generateRandom(1,BallType.values().length);
        BallType ballType = BallType.values()[ballTypeindex];
        if(ballType == BallType.WIDE_BALL)
            this.runs = 1;
        else if(ballType == BallType.NO_BALL)
        {
            this.runs = 1;
            this.runs += Util.generateRandom(1,6);
        }
        else if(ballType == BallType.FAIR)
            this.runs += Util.generateRandom(1,6);

        for(ScoreUpdater scoreUpdater: scoreUpdaterList_)
        {
            scoreUpdater.update(this);
        }
    }


}
