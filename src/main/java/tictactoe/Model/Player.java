package tictactoe.Model;

public class Player {
    public String playerID;
    public PlayingPiece playingPiece;

    public Player(String playerID, PlayingPiece playingPiece) {
        this.playerID = playerID;
        this.playingPiece = playingPiece;
    }

}
