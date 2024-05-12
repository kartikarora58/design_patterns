package org.cricbuzzv2;

import java.util.List;
import java.util.Queue;

public class BattingController {
    Player strike;
    Player nonStrike;
    Queue<Player> playerQueue_;

    public void rotateStrike()
    {
        Player temp = this.strike;
        this.strike = this.nonStrike;
        this.nonStrike = temp;
    }

    public void chooseNextBatsman(Player outPlayer)
    {
        Player player = playerQueue_.remove();
        if(strike == outPlayer)
            strike = player;
        else
            outPlayer = player;
    }


}
