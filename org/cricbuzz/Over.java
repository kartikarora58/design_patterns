package org.cricbuzz;

import java.util.List;

public class Over {
    int overNumber;
    List<Ball> balls;
    Player bowler;
    Over(int overNumber)
    {
        this.overNumber = overNumber;
        this.bowler = bowler;
    }
    public void startOver(Team batting,Team bowling,int targetScore,Match match)
    {
        int ballCount = 0;
        while(ballCount<6)
        {
            Ball ball = new Ball(ballCount,batting.getStriker(),bowling.getCurrentBowler());
            ball.throwBall();
            if(ball.ballTye_ == BallType.WICKET)
            {
                batting.chooseNextBatsMan();
                ballCount++;
            }
            else if(ball.ballTye_ == BallType.FAIR)
            {
                if((ball.runs&1) == 1)
                    batting.rotateStrike();
                ballCount++;
            }
            else if(ball.ballTye_ == BallType.NO_BALL)
            {
                if(((ball.runs-1)&1) == 1)
                    batting.rotateStrike();
            }
            if(targetScore!=-1 && batting.getTotalRuns()>=targetScore)
            {
                match.setMatchStatus(MatchStatus.END);
                match.setWinner(batting);
                return;
            }

        }
    }
}
