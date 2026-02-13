package FlyWeightDesignPatttern.WordProcessor;

public class DocumentLetter implements ILetter{

    private final char character;
    private final String font;
    private final int size;

    DocumentLetter(char character, String font, int size) {
        this.character = character;
        this.font = font;
        this.size = size;
    }

    public char getCharacter() {
        return this.character;
    }

    public String getFont() {
        return this.font;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public void display(int row, int col) {
        System.out.println("Displaying " + character + " at row: " + row + " column: " + col);
    }
}
