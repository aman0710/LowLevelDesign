package LLDofCricBuzz.Team.Player;

import java.util.*;

public class PlayerBowlingController {
    Deque<Player> bowlersList;
    Map<Player, Integer> bowlerVsOverCount;
    Player currentBowler;

    public PlayerBowlingController(List<Player> bowlers) {
        setBowlersList(bowlers);
    }

    public void setBowlersList(List<Player> bowlersList) {
        this.bowlersList = new LinkedList<>();
        this.bowlerVsOverCount = new HashMap<>();
        for(Player player: bowlersList) {
            this.bowlersList.addLast(player);
            this.bowlerVsOverCount.put(player, 0);
        }
    }

    public Player getCurrentBowler() {
        return this.currentBowler;
    }

    public void getNextBowler(int maxOversAllowedPerBowler) {
        Player player = this.bowlersList.poll();
        if(bowlerVsOverCount.get(player) + 1 == maxOversAllowedPerBowler)
            currentBowler = player;
        else {
            currentBowler = player;
            bowlersList.addLast(player);
            bowlerVsOverCount.put(player, bowlerVsOverCount.get(player) + 1);
        }
    }
}
