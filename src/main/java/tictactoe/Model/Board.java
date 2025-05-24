package tictactoe.Model;

public class Board {
    public int size;

    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public void printBoard() {
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(board[i][j] == null)
                    System.out.print("   |");
                else
                    System.out.print(" " + board[i][j].pieceType + " |");
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(board[i][j] == null)
                    return false;
            }
        }
        return true;
    }

    public boolean addPiece(int row, int column, PlayingPiece playingPiece) {
        if(row < 0 || row >= size || column < 0 || column >= size)
            return false;
        if(board[row][column] != null)
            return false;
        board[row][column] = playingPiece;
        return true;
    }
}
