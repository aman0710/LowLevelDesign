package LLDofTicTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {

    public Board board;
    public Deque<Player> players;

    public TicTacToeGame(int size) {
        this.board = new Board(size);
        this.players = new LinkedList<>();

        PlayingPieceO circlePiece = new PlayingPieceO(PieceType.O);
        Player player1 = new Player(1, "Player1", circlePiece);

        PlayingPieceX crossPiece = new PlayingPieceX(PieceType.X);
        Player player2 = new Player(2, "Player2", crossPiece);

        players.add(player1);
        players.add(player2);

        startGame();
    }

    public void startGame() {
        boolean concluded = false;
        boolean isTie = false;
        Player winner = null;

        while(!concluded) {
            Player currPlayer = players.removeFirst();
            if(!board.hasFreeCells()) {
                isTie = true;
                break;
            }
            board.printBoard();
            System.out.println("Turn of : " + currPlayer.name);
            System.out.println("Enter the cell as \"row,column\": ");
            Scanner inputScanner = new Scanner(System.in);
            String input = inputScanner.nextLine();
            String[] values = input.split(",");
            int rowValue = Integer.parseInt(values[0]);
            int colValue = Integer.parseInt(values[1]);

            boolean isValidMove = board.addPiece(rowValue, colValue, currPlayer.playingPiece);
            if(!isValidMove) {
                players.addFirst(currPlayer);
                continue;
            }

            players.addLast(currPlayer);
            concluded = checkWinner(rowValue, colValue, currPlayer.playingPiece.pieceType);
            if(concluded) {
                winner = currPlayer;
                break;
            }
        }

        board.printBoard();

        if(isTie)
            System.out.println("The game ended in a tie!");
        else {
            System.out.println("The winner of the game is : ");
            System.out.println("Name: " + winner.name);
            System.out.println("ID: " + winner.playerId);
            System.out.println("Playing Piece: " + winner.playingPiece.pieceType);
        }
    }

    public boolean checkWinner(int row, int col, PieceType pieceType) {
        boolean rowMatch = true, colMatch = true, diagonalMatch = false, antiDiagonalMatch = false;

        for(int i=0; i<board.size; i++) {
            if(board.gameBoard[i][col] == null || board.gameBoard[i][col].pieceType != pieceType) {
                colMatch = false;
                break;
            }
        }

        for(int j=0; j<board.size; j++) {
            if(board.gameBoard[row][j] == null || board.gameBoard[row][j].pieceType != pieceType) {
                rowMatch = false;
                break;
            }
        }

        if(row == col) {
            diagonalMatch = true;
            for(int i=0; i<board.size; i++) {
                if(board.gameBoard[i][i] == null || board.gameBoard[i][i].pieceType != pieceType) {
                    diagonalMatch = false;
                    break;
                }
            }
        }

        if(row + col == board.size - 1) {
            antiDiagonalMatch = true;
            for(int i=0; i<board.size; i++) {
                int column = board.size - 1 - i;
                if(board.gameBoard[i][column] == null || board.gameBoard[i][column].pieceType != pieceType) {
                    antiDiagonalMatch = false;
                    break;
                }
            }
        }

        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }
}
