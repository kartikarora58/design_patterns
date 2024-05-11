package org.cricbuzzv2;

import org.cricbuzz.BallType;

public class Ball {
    Player bowler;
    Player batsman;
    int runs;
    BallType ballType_;

    Ball(Player bowler,Player batsman)
    {
        this.bowler = bowler;
        this.batsman = batsman;
    }




}
