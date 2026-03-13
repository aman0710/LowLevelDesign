package InterpreterDesignPattern;

public class NumberExpression implements IExpression{

    String key;

    public NumberExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpret(Context context) {
        return context.get(key);
    }
}
