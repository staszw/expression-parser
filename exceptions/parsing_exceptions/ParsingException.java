package expression.exceptions.parsing_exceptions;

public class ParsingException extends RuntimeException {
    public ParsingException(final String message, final int position) {
        super(message + "; position: " + position);
    }
}
