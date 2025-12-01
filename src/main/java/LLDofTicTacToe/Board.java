package LLDofTicTacToe;

public class Board {
    public int size;
    public int freeCells;
    PlayingPiece[][] gameBoard;
    public Board(int size) {
        this.size = size;
        this.freeCells = size * size;
        this.gameBoard = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece) {
        if(row < 0 || row >= size || col < 0 || col >= size) {
            System.out.println("Chosen cell is out of bounds, please try again...");
            return false;
        }
        if(gameBoard[row][col] != null) {
            System.out.println("The cell is not empty, please try again...");
            return false;
        }
        gameBoard[row][col] = playingPiece;
        return true;
    }

    public boolean hasFreeCells() {
        return freeCells > 0;
    }

    public void printBoard() {
        System.out.println("The current status of the game board is: ");
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(gameBoard[i][j] == null)
                    System.out.print("   |");
                else
                    System.out.print(" " + gameBoard[i][j].pieceType + " |");
            }
            System.out.println("\n");
        }
    }
}
