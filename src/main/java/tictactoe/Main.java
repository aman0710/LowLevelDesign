package tictactoe;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        String winner = game.startGame();
        System.out.println("The winner of the game is : " + winner);
    }
}