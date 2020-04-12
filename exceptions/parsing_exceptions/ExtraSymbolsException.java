package expression.exceptions.parsing_exceptions;

public class ExtraSymbolsException extends ParsingException {
    public ExtraSymbolsException(int position) {
        super("Unexpected symbols at the end", position);
    }
}
