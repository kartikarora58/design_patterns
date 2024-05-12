package org.cricbuzzv2;

public class BattingStatusUpdate implements PlayerstatusUpdate{
    @Override
    public void updatePlayerInfo(Ball ball) {
        Player batsman = ball.batsman;
        batsman.playerBattingStats_.runs+= ball.runs;
        if(ball.runs == 4)
            batsman.playerBattingStats_.fours+=1;
        else if(ball.runs == 6)
            batsman.playerBattingStats_.sixes+=1;
        batsman.playerBattingStats_.balls+=1;
    }
}
