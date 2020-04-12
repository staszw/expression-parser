package expression.parser;

import expression.CommonExpression;
import expression.exceptions.parsing_exceptions.ExtraSymbolsException;
import expression.exceptions.parsing_exceptions.InvalidConstException;
import expression.exceptions.parsing_exceptions.InvalidVariableException;
import expression.exceptions.parsing_exceptions.NotFoundException;
import expression.operations.*;
import expression.operations.BinaryOperation;
import expression.Const;
import expression.Variable;

import java.util.List;

public class ExpressionParser extends BaseParser implements Parser {
    private static final List< List<String> > PRIORITIES = List.of(
            List.of("*", "/"),
            List.of("+", "-"),
            List.of("min", "max")
    );
    private static final int MAX_LEVEL = PRIORITIES.size() - 1;
    private static final int MIN_LEVEL = -1;

    private static final List<Character> SPECIAL_SYMBOLS = List.of('+', '-', '/', '*', '(', ')', '\0');

    @Override
    public CommonExpression parse(String expression) {
        setSource(new StringSource(expression));
        skipWhitespace();
        CommonExpression result = parse(MAX_LEVEL);
        if (ch != '\0') {
            throw new ExtraSymbolsException(getPosition());
        }
        return result;
    }

    private CommonExpression parse(int level) {
        if (level == MIN_LEVEL) {
            return getMinLevelExpression();
        }
        skipWhitespace();
        CommonExpression current = parse(level - 1);
        boolean flag = true;
        while (flag) {
            flag = false;
            skipWhitespace();
            for (String operation : PRIORITIES.get(level)) {
                if (test(operation)) {
                    current = getExpression(operation, current, parse(level - 1));
                    flag = true;
                }
            }
        }
        return current;
    }

    private CommonExpression getMinLevelExpression() {
        skipWhitespace();
        if (test('-')) {
            if (isDigit()) {
                return getConst(true);
            } else {
                return new Negate(getMinLevelExpression());
            }
        } else if (isDigit()) {
            return getConst(false);
        } else if (test('(')) {
            CommonExpression result = parse(MAX_LEVEL);
            expect(')');
            return result;
        } else {
            StringBuilder builder = new StringBuilder();
            skipWhitespace();
            while (!SPECIAL_SYMBOLS.contains(ch) && !Character.isWhitespace(ch)) {
                builder.append(ch);
                nextChar();
            }
            skipWhitespace();

            String value = builder.toString();
            switch (value) {
                case "count":
                    return new Count(getMinLevelExpression());
                case "x":
                case "y":
                case "z":
                    return new Variable(value);
                case "":
                    throw new NotFoundException("variable, found nothing", getPosition());
                default:
                    throw new InvalidVariableException(value, getPosition());
            }
        }
    }

    private Const getConst(boolean isNegative) {
        StringBuilder builder = new StringBuilder();
        if (isNegative) {
            builder.append("-");
        }
        while (isDigit()) {
            builder.append(ch);
            nextChar();
        }
        String value = builder.toString();
        try {
            return new Const(value);
        } catch (NumberFormatException e) {
            throw new InvalidConstException(value, getPosition());
        }
    }

    private BinaryOperation getExpression(String lastOperation, CommonExpression left, CommonExpression right) {
        switch (lastOperation) {
            case "+":
                return new Add(left, right);
            case "-":
                return new Subtract(left, right);
            case "*":
                return new Multiply(left, right);
            case "/":
                return new Divide(left, right);
            case "min":
                return new Min(left, right);
            case "max":
                return new Max(left, right);
            default:
                throw new AssertionError("Unsupported operation " + lastOperation);
        }
    }
}
