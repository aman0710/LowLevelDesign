package CricBuzzLLD.ScoreUpdater;

import CricBuzzLLD.Inning.BallDetails;
import CricBuzzLLD.Inning.BallType;
import CricBuzzLLD.Inning.RunType;

public class BowlingScoreUpdater implements ScoreUpdaterObserver{
    @Override
    public void update(BallDetails ballDetails) {
        if(ballDetails.ballNumber == 6 && ballDetails.ballType == BallType.NORMAL) {
            ballDetails.bowledBy.bowlingScoreCard.totalOversCount++;
        }
        if(ballDetails.runType == RunType.ONE) {
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 1;
        }
        if(ballDetails.runType == RunType.TWO) {
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 2;
        }
        if(ballDetails.runType == RunType.THREE) {
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 3;
        }
        if(ballDetails.runType == RunType.FOUR) {
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 4;
        }
        if(ballDetails.runType == RunType.FIVE) {
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 5;
        }
        if(ballDetails.runType == RunType.SIX) {
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 6;
        }

        if(ballDetails.wicket != null) {
            ballDetails.bowledBy.bowlingScoreCard.wicketsTaken++;
        }

        if(ballDetails.ballType == BallType.NO_BALL) {
            ballDetails.bowledBy.bowlingScoreCard.noBallCount++;
        }

        if(ballDetails.ballType == BallType.WIDE_BALL) {
            ballDetails.bowledBy.bowlingScoreCard.wideBallCount++;
        }
    }
}
