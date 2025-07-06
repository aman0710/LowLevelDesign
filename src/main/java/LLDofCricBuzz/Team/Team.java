package LLDofCricBuzz.Team;

import LLDofCricBuzz.Team.Player.Player;
import LLDofCricBuzz.Team.Player.PlayerBattingController;
import LLDofCricBuzz.Team.Player.PlayerBowlingController;

import java.util.List;
import java.util.Queue;

public class Team {
    String name;
    Queue<Player> playing11;
    List<Player> benched;
    PlayerBattingController battingController;
    PlayerBowlingController bowlingController;
    public boolean isWinner;

    public Team(String name, Queue<Player> playing11, List<Player> benched, List<Player> bowlers) {
        this.name = name;
        this.playing11 = playing11;
        this.benched = benched;
        this.battingController = new PlayerBattingController(playing11);
        this.bowlingController = new PlayerBowlingController(bowlers);
    }

    public String getName() {
        return this.name;
    }

    public void chooseNextBatsman() throws Exception{
        battingController.getNextPlayer();
    }

    public void chooseNextBowler(int maxOversAllowedPerBowler) {
        bowlingController.getNextBowler(maxOversAllowedPerBowler);
    }

    public Player getStriker() {
        return battingController.getStriker();
    }

    public Player getNonStriker() {
        return battingController.getNonStriker();
    }

    public void setStriker(Player striker) {
        battingController.setStriker(striker);
    }

    public void setNonStriker(Player nonStriker) {
        battingController.setNonStriker(nonStriker);
    }

    public Player getCurrentBowler() {
        return bowlingController.getCurrentBowler();
    }

    public void printBattingScoreCard() {
        for(Player player: playing11)
            player.printBattingScoreCard();
    }

    public void printBowlingScoreCard() {
        for(Player player: playing11) {
            if(player.bowlingScoreCard.totalOversCount > 0)
                player.printBowlingScoreCard();
        }
    }

    public int getTotalRuns() {
        int totalRuns = 0;
        for(Player player: playing11) {
            totalRuns += player.battingScoreCard.totalRuns;
        }
        return totalRuns;
    }
}
