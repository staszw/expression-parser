package expression.exceptions.parsing_exceptions;

public class InvalidVariableException extends ParsingException {
    public InvalidVariableException(String message, int position) {
        super("Invalid name of variable \"" + message + "\"", position);
    }
}
