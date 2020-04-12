package expression.exceptions.expression_exceptions;

public class DivideByZeroException extends ExpressionException {
    public DivideByZeroException() {
        super("Division by zero");
    }
}
