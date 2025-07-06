package LLDofCricBuzz.Team;

import LLDofCricBuzz.Inning.Ball;
import LLDofCricBuzz.Inning.Over;
import LLDofCricBuzz.Team.Player.Player;

public class Wicket {
    WicketType wicketType;
    public Player takenBy;
    Over over;
    Ball ball;

    public Wicket(WicketType wicketType, Player takenBy, Over over, Ball ball) {
        this.wicketType = wicketType;
        this.takenBy = takenBy;
        this.over = over;
        this.ball = ball;
    }
}
