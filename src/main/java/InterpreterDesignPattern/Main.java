package InterpreterDesignPattern;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.put("a", 2);
        context.put("b", 4);
        context.put("c", 8);
        context.put("d", 16);

        IExpression expression = new BinaryExpression(
                new BinaryExpression(new NumberExpression("a"), new NumberExpression("b"), '*'),
                new BinaryExpression(new NumberExpression("c"), new NumberExpression("d"), '*'),
                '+');
        System.out.println("Result of the expression: " + expression.interpret(context));
    }
}
