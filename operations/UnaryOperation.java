package expression.operations;

import expression.CommonExpression;
import expression.generic.calculators.AbstractCalculator;

public abstract class UnaryOperation extends CommonExpression {
    private final CommonExpression inner;

    public UnaryOperation(CommonExpression inner) {
        this.inner = inner;
    }

    public abstract <T extends Number> T calculate(T x, AbstractCalculator<T> calculator);

    public abstract String getSymbol();

    @Override
    public <T extends Number> T evaluate(T x, AbstractCalculator<T> calculator) {
        return calculate(inner.evaluate(x, calculator), calculator);
    }

    @Override
    public <T extends Number> T evaluate(T x, T y, T z, AbstractCalculator<T> calculator) {
        return calculate(inner.evaluate(x, y, z, calculator), calculator);
    }

    @Override
    public String toString() {
        return getSymbol() + "(" + inner.toString() + ")";
    }

    @Override
    public String toMiniString() {
        boolean checkBrackets = inner instanceof BinaryOperation;
        return getSymbol() +
                (checkBrackets ? "(" : "") +
                inner.toMiniString() +
                (checkBrackets ? ")" : "");
    }
}
