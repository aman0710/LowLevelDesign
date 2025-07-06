package LLDofCricBuzz.ScoreUpdater;

import LLDofCricBuzz.Inning.Ball;
import LLDofCricBuzz.Inning.BallType;
import LLDofCricBuzz.Inning.RunType;

public class BowlingScoreUpdater implements ScoreUpdaterObserver{
    @Override
    public void update(Ball ball) {
        if (ball.ballNumber == 6 && ball.ballType == BallType.NORMAL) {
            ball.bowledBy.bowlingScoreCard.totalOversCount++;
        }

        if (RunType.ONE == ball.runType) {
            ball.bowledBy.bowlingScoreCard.runsGiven += 1;
        } else if (RunType.TWO == ball.runType) {
            ball.bowledBy.bowlingScoreCard.runsGiven += 2;
        } else if (RunType.FOUR == ball.runType) {
            ball.bowledBy.bowlingScoreCard.runsGiven += 4;
        } else if (RunType.SIX == ball.runType) {
            ball.bowledBy.bowlingScoreCard.runsGiven += 6;
        }

        if (ball.wicket != null) {
            ball.bowledBy.bowlingScoreCard.wicketsTaken++;
        }

        if (ball.ballType == BallType.NOBALL) {
            ball.bowledBy.bowlingScoreCard.noBallCount++;
        }

        if (ball.ballType == BallType.WIDEBALL) {
            ball.bowledBy.bowlingScoreCard.wideBallCount++;
        }

    }
}
