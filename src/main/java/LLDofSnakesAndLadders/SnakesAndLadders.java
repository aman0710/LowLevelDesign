package LLDofSnakesAndLadders;

import java.util.Deque;
import java.util.LinkedList;

public class SnakesAndLadders {
    Board gameBoard;
    Dice dice;
    Deque<Player> players;
    Player winner;

    public SnakesAndLadders(int boardSize, int diceCount, int snakes, int ladders, int players) {
        this.players = new LinkedList<>();
        this.winner = null;
        initializeGame(boardSize, diceCount, snakes, ladders, players);
    }

    public void initializeGame(int boardSize, int diceCount, int snakes, int ladders, int players) {
        this.gameBoard = new Board(boardSize);
        this.dice = new Dice(diceCount);
        gameBoard.addSnakesAndLadders(snakes, ladders);
        for(int i=0; i<players; i++) {
            Player player = new Player("Player-"+(i+1), 0);
            this.players.add(player);
        }
    }

    public void startGame() {
        while(winner == null) {
            Player playerTurn = this.players.removeFirst();
            this.players.addLast(playerTurn);
            System.out.println("\nPlayer Turn: " + playerTurn.playerId);
            System.out.println("current position: " + playerTurn.currentPos);
            int newPos = playerTurn.currentPos + this.dice.rollDice();
            if(newPos >= this.gameBoard.cells.length*this.gameBoard.cells.length - 1) {
                winner = playerTurn;
                break;
            }
            newPos = jumpCheck(newPos);
            playerTurn.currentPos = newPos;
            System.out.println("new position: " + playerTurn.currentPos);
        }
        System.out.println("\n=====> The winner is: " + winner.playerId);
    }

    public int jumpCheck(int cellNumber) {
        Cell cell = gameBoard.getCell(cellNumber);
        int newPosition = cellNumber;
        if(cell.jump != null && cell.jump.startPos == cellNumber) {
            newPosition = cell.jump.endPos;
            String jumpElement = (cell.jump.startPos > cell.jump.endPos) ? "SNAKE" : "LADDER";
            System.out.println("[+] Jump occurred by: " + jumpElement);
        }
        return newPosition;
    }
}
