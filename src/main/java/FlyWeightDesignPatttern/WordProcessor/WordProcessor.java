package FlyWeightDesignPatttern.WordProcessor;

public class WordProcessor {
    public static void main(String[] args) {
        ILetter letter1 = LetterFactory.createLetter('t');
        ILetter letter2 = LetterFactory.createLetter('t');
        letter1.display(1, 2);
        letter2.display(4, 5);
        System.out.println("Total number of letters: " + LetterFactory.getTotalLetters());
    }
}
