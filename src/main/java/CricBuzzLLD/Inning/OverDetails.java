package CricBuzzLLD.Inning;

import CricBuzzLLD.Team.Player.PlayerDetails;
import CricBuzzLLD.Team.Team;

import java.util.ArrayList;
import java.util.List;

public class OverDetails {
    int overNumber;
    List<BallDetails> balls;
    int extraBallsCount;
    PlayerDetails bowledBy;

    public OverDetails(int overNumber, PlayerDetails bowledBy) {
        this.overNumber = overNumber;
        this.bowledBy = bowledBy;
        balls = new ArrayList<>();
    }

    public boolean startOver(Team battingTeam, Team bowlingTeam, int runsToWin) throws Exception {
        int ballCount = 1;
        while (ballCount <= 6) {
            BallDetails ball = new BallDetails(ballCount);
            ball.startBallDelivery(battingTeam, bowlingTeam, this);
            if(ball.ballType == BallType.NORMAL) {
                balls.add(ball);
                ballCount++;
                if(ball.wicket != null) {
                    battingTeam.chooseNextBatsman();
                }
                if(runsToWin != -1 && battingTeam.geTotalRuns() >= runsToWin) {
                    battingTeam.isWinner = true;
                    break;
                }
            } else {
                extraBallsCount++;
            }
        }
        return false;
    }
}
