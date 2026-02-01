package CricBuzzLLD.ScoreUpdater;

import CricBuzzLLD.Inning.BallDetails;

public interface ScoreUpdaterObserver {
    void update(BallDetails ballDetails);
}
