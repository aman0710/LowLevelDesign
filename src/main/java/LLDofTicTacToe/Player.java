package LLDofTicTacToe;

public class Player {
    public int playerId;
    public String name;
    public PlayingPiece playingPiece;

    public Player(int id, String name, PlayingPiece playingPiece) {
        this.playerId = id;
        this.name = name;
        this.playingPiece = playingPiece;
    }
}
