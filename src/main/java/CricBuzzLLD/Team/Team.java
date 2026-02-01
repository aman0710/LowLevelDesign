package CricBuzzLLD.Team;

import CricBuzzLLD.Team.Player.PlayerBattingController;
import CricBuzzLLD.Team.Player.PlayerBowlingController;
import CricBuzzLLD.Team.Player.PlayerDetails;
import LLDofTicTacToe.Player;

import java.util.List;
import java.util.Queue;

public class Team {
    public String teamName;
    public Queue<PlayerDetails> playing11;
    public List<PlayerDetails> bench;
    public PlayerBattingController battingController;
    public PlayerBowlingController bowlingController;
    public boolean isWinner;

    public Team(String teamName, Queue<PlayerDetails> playing11, List<PlayerDetails> bench, List<PlayerDetails> bowlers) {
        this.teamName = teamName;
        this.playing11 = playing11;
        this.bench = bench;
        battingController = new PlayerBattingController(playing11);
        bowlingController = new PlayerBowlingController(bowlers);
    }

    public String getTeamName() {
        return teamName;
    }

    public void chooseNextBatsman() throws Exception {
        battingController.getNextPlayer();
    }

    public void chooseNextBowler(int maxOverCountPerBowler) {
        bowlingController.getNextBowler(maxOverCountPerBowler);
    }

    public PlayerDetails getStriker() {
        return battingController.getStriker();
    }

    public PlayerDetails getNonStriker() {
        return battingController.getNonStriker();
    }

    public void setStriker(PlayerDetails striker) {
        battingController.setStriker(striker);
    }

    public void setNonStriker(PlayerDetails nonStriker) {
        battingController.setNonStriker(nonStriker);
    }

    public PlayerDetails getCurrentBowler() {
        return bowlingController.getCurrentBowler();
    }

    public void printBattingScoreCard() {
        for(PlayerDetails player: playing11) {
            player.printBattingScoreCard();
        }
    }

    public void printBowlingScoreCard() {
        for(PlayerDetails player: playing11) {
            if(player.bowlingScoreCard.totalOversCount > 0)
                player.printBowlingScoreCard();
        }
    }

    public int geTotalRuns() {
        int totalRuns = 0;
        for(PlayerDetails player: playing11) {
            totalRuns += player.battingScoreCard.totalRuns;
        }
        return totalRuns;
    }
}
