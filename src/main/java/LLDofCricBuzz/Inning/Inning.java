package LLDofCricBuzz.Inning;

import LLDofCricBuzz.MatchType.MatchType;
import LLDofCricBuzz.Team.Player.Player;
import LLDofCricBuzz.Team.Team;

import java.util.ArrayList;
import java.util.List;

public class Inning {
    Team battingTeam;
    Team bowlingTeam;
    MatchType matchType;
    List<Over> overs;

    public Inning(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        overs = new ArrayList<>();
    }

    public void start(int runsToWin){

        //set batting players
        try {
            battingTeam.chooseNextBatsman();
        }catch (Exception e) {

        }

        int noOfOvers = matchType.numberOfOvers();
        for (int overNumber = 1; overNumber <= noOfOvers; overNumber++) {

            //chooseBowler
            bowlingTeam.chooseNextBowler(matchType.maxOversAllowedPerBowler());

            Over over = new Over(overNumber, bowlingTeam.getCurrentBowler());
            overs.add(over);
            try {
                boolean won = over.startOver(battingTeam, bowlingTeam, runsToWin);
                if(won == true) {
                    break;
                }
            }catch (Exception e) {
                break;
            }

            //swap striker and non striker
            Player temp = battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(temp);
        }
    }

    public int getTotalRuns(){
        return battingTeam.getTotalRuns();
    }

}
