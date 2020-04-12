package expression.parser;

public interface Parser {
    expression.TripleExpression parse(String expression);
}
