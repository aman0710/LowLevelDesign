package InterpreterDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class Context {
    Map<String, Integer> context = new HashMap<>();

    public void put(String key, int val) {
        context.put(key, val);
    }

    public int get(String key) {
        return context.get(key);
    }
}
