package FlyWeightDesignPatttern.WordProcessor;

import java.util.HashMap;
import java.util.Map;

public class LetterFactory {
    public static Map<Character, ILetter> characterCache = new HashMap<>();

    public static ILetter createLetter(char characterType) {
        if(characterCache.containsKey(characterType)) {
            return characterCache.get(characterType);
        } else {
            ILetter letter = new DocumentLetter(characterType, "Times New Roman", 10);
            characterCache.put(characterType, letter);
            return letter;
        }
    }

    public static int getTotalLetters() {
        return characterCache.size();
    }
}
