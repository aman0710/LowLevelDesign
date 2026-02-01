package CricBuzzLLD.ScoreUpdater;

import CricBuzzLLD.Inning.BallDetails;
import CricBuzzLLD.Inning.RunType;

public class BattingScoreUpdater implements ScoreUpdaterObserver{
    @Override
    public void update(BallDetails ballDetails) {
        int run = 0;
        if(ballDetails.runType == RunType.ONE)
            run = 1;
        if(ballDetails.runType == RunType.TWO)
            run = 2;
        if(ballDetails.runType == RunType.THREE)
            run = 3;
        if(ballDetails.runType == RunType.FOUR) {
            run = 4;
            ballDetails.playedBy.battingScoreCard.totalFours++;
        }
        if(ballDetails.runType == RunType.FIVE)
            run = 5;
        if(ballDetails.runType == RunType.SIX) {
            run = 6;
            ballDetails.playedBy.battingScoreCard.totalSix++;
        }

        ballDetails.playedBy.battingScoreCard.totalRuns += run;
        ballDetails.playedBy.battingScoreCard.totalBallsPlayed++;

        if(ballDetails.wicket != null) {
            ballDetails.playedBy.battingScoreCard.wicketDetails = ballDetails.wicket;
        }
    }
}
