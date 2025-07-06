package LLDofCricBuzz.Team.Player;

import LLDofCricBuzz.Team.Player.ScoreCard.BattingScoreCard;
import LLDofCricBuzz.Team.Player.ScoreCard.BowlingScoreCard;

public class Player {
    public Person person;
    PlayerType playerType;
    public BattingScoreCard battingScoreCard;
    public BowlingScoreCard bowlingScoreCard;

    public Player(Person person, PlayerType playerType) {
        this.person = person;
        this.playerType = playerType;
        this.battingScoreCard = new BattingScoreCard();
        this.bowlingScoreCard = new BowlingScoreCard();
    }

    public void printBattingScoreCard() {
        System.out.println("Player Name: " + person.name + " -- Total Runs: " + battingScoreCard.totalRuns + " -- Total Balls Played: " + battingScoreCard.totalBallsPlayed + " -- 4s: " + battingScoreCard.totalFours + " -- 6s: " + battingScoreCard.totalSixes + " -- Dismissed by: " + ((battingScoreCard.wicketDetails != null) ? battingScoreCard.wicketDetails.takenBy.person.name : "Not Out"));
    }

    public void printBowlingScoreCard() {
        System.out.println("Player Name: " + person.name + " -- Overs Thrown: " + bowlingScoreCard.totalOversCount + " -- Runs Given: " + bowlingScoreCard.runsGiven + " -- Wickets Taken: " + bowlingScoreCard.wicketsTaken);
    }
}
