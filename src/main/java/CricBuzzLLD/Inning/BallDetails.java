package CricBuzzLLD.Inning;

import CricBuzzLLD.ScoreUpdater.BattingScoreUpdater;
import CricBuzzLLD.ScoreUpdater.BowlingScoreUpdater;
import CricBuzzLLD.ScoreUpdater.ScoreUpdaterObserver;
import CricBuzzLLD.Team.Player.PlayerDetails;
import CricBuzzLLD.Team.Team;
import CricBuzzLLD.Team.Wicket;
import CricBuzzLLD.Team.WicketType;

import java.util.ArrayList;
import java.util.List;

public class BallDetails {
    public int ballNumber;
    public BallType ballType;
    public RunType runType;
    public PlayerDetails playedBy;
    public PlayerDetails bowledBy;
    public Wicket wicket;
    List<ScoreUpdaterObserver> scoreUpdaterObserverList = new ArrayList<>();

    public BallDetails(int ballNumber) {
        this.ballNumber = ballNumber;
        scoreUpdaterObserverList.add(new BowlingScoreUpdater());
        scoreUpdaterObserverList.add(new BattingScoreUpdater());
    }

    public void startBallDelivery(Team battingTeam, Team bowlingTeam, OverDetails over) {
        playedBy = battingTeam.getStriker();
        bowledBy = over.bowledBy;
        ballType = BallType.NORMAL;

        if(isWicketTaken()) {
            runType = RunType.ZERO;
            wicket = new Wicket(WicketType.BOWLED, bowlingTeam.getCurrentBowler(), over, this);
            battingTeam.setStriker(null);
        } else {
            runType = getRunType();
            if(runType == RunType.ONE || runType == RunType.THREE) {
                PlayerDetails temp = battingTeam.getStriker();
                battingTeam.setStriker(battingTeam.getNonStriker());
                battingTeam.setNonStriker(temp);
            }
        }
        notifyUpdaters(this);
    }

    private void notifyUpdaters(BallDetails ballDetails) {
        for(ScoreUpdaterObserver scoreUpdaterObserver: scoreUpdaterObserverList) {
            scoreUpdaterObserver.update(ballDetails);
        }
    }

    private RunType getRunType() {
        double val = Math.random();
        if(val <= 0.2)
            return RunType.ONE;
        if(val >= 0.3 && val <= 0.5)
            return RunType.TWO;
        if(val >= 0.6 && val <= 0.8)
            return RunType.FOUR;
        return RunType.SIX;
    }

    private boolean isWicketTaken() {
        if(Math.random() < 0.2)
            return true;
        return false;
    }
}
