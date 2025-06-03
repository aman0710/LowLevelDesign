package SnakesAndLadders;

public class Board {
    public Cell[][] board;
    public int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.board = new Cell[boardSize][boardSize];

        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) {
                board[i][j] = new Cell();
                board[i][j].jump = new Jump(-1, -1);
            }
        }
    }
}
