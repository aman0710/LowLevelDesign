package SnakesAndLadders;

import java.util.Deque;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private Board gameBoard;
    private Dice dice;
    private Deque<Player> players;

    private Player winner;

    public Game(int boardSize, int diceCount, Deque<Player> players, int numberOfSnakes, int numberOfLadders) {
        this.winner = null;
        this.gameBoard = new Board(boardSize);
        this.dice = new Dice(diceCount);
        this.players = players;
        int snakes = numberOfSnakes, ladders = numberOfLadders;
        while(snakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, boardSize*boardSize - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, boardSize*boardSize - 1);

            if(snakeHead <= snakeTail)
                continue;

            Cell cell = getCell(snakeHead);
            Jump snakeJump = new Jump(snakeHead, snakeTail);
            cell.jump = snakeJump;
            snakes--;
        }

        while(ladders > 0) {
            int ladderHead = ThreadLocalRandom.current().nextInt(1, boardSize*boardSize - 1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1, boardSize*boardSize - 1);

            if(ladderHead >= ladderTail)
                continue;

            Cell cell = getCell(ladderHead);
            Jump ladderJump = new Jump(ladderHead, ladderTail);
            cell.jump = ladderJump;
            ladders--;
        }
    }


    public void startGame() {
        while(this.winner == null) {
            Player playerTurn = players.removeFirst();
            players.addLast(playerTurn);
            System.out.println("Current player is : " + playerTurn.id);
            int diceNumber = dice.rollDice();
            System.out.println("Dice number is : " + diceNumber);
            int newPosition = playerTurn.currentPosition + diceNumber;
            if(newPosition >= gameBoard.boardSize*gameBoard.boardSize) {
                winner = playerTurn;
                break;
            }
            Cell cell = getCell(newPosition);
            if(cell.jump.start == newPosition){
                String jumpObj = cell.jump.start > cell.jump.end ? "Snake" : "Ladder";
                System.out.println("Jump by : " + jumpObj);
                newPosition = cell.jump.end;
            }
            System.out.println("New Position of " + playerTurn.id + " is : " + newPosition);
            playerTurn.currentPosition = newPosition;
        }
        System.out.println("Winner is: " + this.winner.id);
    }

    public Cell getCell(int start) {
        int row = start / gameBoard.board[0].length;
        int col = start % gameBoard.board[0].length;
        return gameBoard.board[row][col];
    }
}
