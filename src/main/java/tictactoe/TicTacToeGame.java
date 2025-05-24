package tictactoe;

import tictactoe.Model.Board;
import tictactoe.Model.PieceType;
import tictactoe.Model.Player;
import tictactoe.Model.PlayingPiece;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    TicTacToeGame() {
        initializeGame();
    }

    Deque<Player> players;
    Board board;

    public void initializeGame() {
        players = new LinkedList<>();
        PlayingPiece cross = new PlayingPiece(PieceType.X);
        Player playerX = new Player("PlayerX", cross);
        players.add(playerX);
        PlayingPiece noughts = new PlayingPiece(PieceType.O);
        Player playerO = new Player("PlayerO", noughts);
        players.add(playerO);

        board = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;

        while(noWinner) {
            board.printBoard();
            boolean isBoardFull = board.isBoardFull();
            if(isBoardFull)
                break;
            Player turnPlayer = players.removeFirst();
            System.out.println("Player Turn: " + turnPlayer.playerID);
            System.out.print("Enter pos (row,column): ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int row = Integer.valueOf(values[0]);
            int col = Integer.valueOf(values[1]);
            boolean pieceAdded = board.addPiece(row, col, turnPlayer.playingPiece);
            if(!pieceAdded) {
                System.out.println("Incorrect move, please try again!");
                players.addFirst(turnPlayer);
                continue;
            }
            if(isThereWinner(row, col, turnPlayer.playingPiece.pieceType)){
                board.printBoard();
                return turnPlayer.playerID;
            }
            players.addLast(turnPlayer);
        }
        return "tie";
    }

    public boolean isThereWinner(int row, int col, PieceType pieceType) {
        boolean rowMatch = true, colMatch = true, diagonalMatch = true, antiDiagonalMatch = true;

        for(int j=0; j<board.size; j++) {
            if(board.board[row][j] == null || board.board[row][j].pieceType != pieceType){
                rowMatch = false;
                break;
            }
        }
        for(int i=0; i< board.size; i++) {
            if(board.board[i][col] == null || board.board[i][col].pieceType != pieceType) {
                colMatch = false;
                break;
            }
        }
        for(int i=0,j=0; i<board.size; i++,j++) {
            if(board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
                break;
            }
        }
        for(int i=0,j= board.size-1; i< board.size; i++,j--) {
            if(board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }
}
