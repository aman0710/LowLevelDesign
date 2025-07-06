package LLDofCricBuzz.ScoreUpdater;

import LLDofCricBuzz.Inning.Ball;

public interface ScoreUpdaterObserver {

    public void update(Ball ball);
}
