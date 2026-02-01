package CricBuzzLLD;

import CricBuzzLLD.Inning.InningDetails;
import CricBuzzLLD.Team.Team;

import java.util.Date;

public class Match {
    Team teamA;
    Team teamB;
    Date matchDate;
    String venue;
    Team tossWinner;
    InningDetails[] innings;
    MatchType matchType;

    public Match(Team teamA, Team teamB, Date matchDate, String venue, MatchType matchType) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.matchDate = matchDate;
        this.venue = venue;
        this.matchType = matchType;
        innings = new InningDetails[2];
    }

    private Team toss(Team teamA, Team teamB) {
        if(Math.random() < 0.5)
            return teamA;
        return teamB;
    }

    public void startMatch() {
        tossWinner = toss(teamA, teamB);
        for(int inning = 1; inning <= 2; inning++) {
            InningDetails inningDetails;
            Team battingTeam;
            Team bowlingTeam;

            if(inning == 1) {
                battingTeam = tossWinner;
                bowlingTeam = tossWinner.getTeamName().equalsIgnoreCase(teamA.getTeamName()) ? teamB : teamA;
                inningDetails = new InningDetails(battingTeam, bowlingTeam, matchType);
                inningDetails.start(-1);
            } else {
                bowlingTeam = tossWinner;
                battingTeam = tossWinner.getTeamName().equalsIgnoreCase(teamA.getTeamName()) ? teamB: teamA;
                inningDetails = new InningDetails(battingTeam, bowlingTeam, matchType);
                inningDetails.start(innings[0].getTotalRuns() + 1);
                if(bowlingTeam.geTotalRuns() > battingTeam.geTotalRuns())
                    bowlingTeam.isWinner = true;
                else
                    battingTeam.isWinner = true;
            }

            innings[inning - 1] = inningDetails;
            System.out.println();
            System.out.println("INNING " + inning + " -- Total Runs: " + battingTeam.geTotalRuns());
            System.out.println("-- Batting Score Card: " + battingTeam.teamName + " --");
            battingTeam.printBattingScoreCard();

            System.out.println();
            System.out.println("-- Bowling Score Card: " + bowlingTeam.teamName + " --");
            bowlingTeam.printBowlingScoreCard();
        }

        System.out.println();
        if(teamA.isWinner)
            System.out.println("---WINNER--- " + teamA.getTeamName());
        else
            System.out.println("---WINNER--- " + teamB.getTeamName());
    }
}
