package expression.operations;

import expression.CommonExpression;
import expression.generic.calculators.AbstractCalculator;

public final class Divide extends BinaryOperation {
    public Divide(CommonExpression left, CommonExpression right) {
        super(left, right);
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public String getSymbol() {
        return "/";
    }

    @Override
    public <T extends Number> T calculate(T x, T y, AbstractCalculator<T> calculator) {
        return calculator.divide(x, y);
    }

    @Override
    public boolean needsExtraBrackets() {
        return true;
    }
}
