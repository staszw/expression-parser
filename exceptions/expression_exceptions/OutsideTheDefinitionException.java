package expression.exceptions.expression_exceptions;

public class OutsideTheDefinitionException extends ExpressionException {
    public OutsideTheDefinitionException(String operation) {
        super("Outside the definition area of " + operation);
    }
}
