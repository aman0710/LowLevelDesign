package LLDofSnakesAndLadders;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    public Board(int boardSize) {
        this.cells = new Cell[boardSize][boardSize];
        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) {
                this.cells[i][j] = new Cell();
            }
        }
    }

    public void addSnakesAndLadders(int snakes, int ladders) {
        int numOfSnakes = 0;
        int numOfLadders = 0;
        while(numOfSnakes < snakes) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length - 1);
            if(snakeHead <= snakeTail)
                continue;
            Jump snakeJump = new Jump(snakeHead, snakeTail);
            Cell cell = getCell(snakeHead);
            cell.jump = snakeJump;
            numOfSnakes++;
        }

        while(numOfLadders < ladders) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length - 1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length - 1);
            if(ladderStart >= ladderEnd)
                continue;
            Jump ladderJump = new Jump(ladderStart, ladderEnd);
            Cell cell = getCell(ladderStart);
            cell.jump = ladderJump;
            numOfLadders++;
        }
    }

    public Cell getCell(int cellNumber) {
        int row = cellNumber / this.cells.length;
        int col = cellNumber % this.cells.length;
        return this.cells[row][col];
    }
}
