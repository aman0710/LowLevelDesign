package SnakesAndLadders;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player1", 0);
        Player player2 = new Player("Player2", 0);
        Deque<Player> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
        Game game = new Game(10, 1, players, 4, 5);
        game.startGame();
    }
}
