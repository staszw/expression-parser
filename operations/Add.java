package expression.operations;

import expression.CommonExpression;
import expression.generic.calculators.AbstractCalculator;

public final class Add extends BinaryOperation {
    public Add(CommonExpression left, CommonExpression right) {
        super(left, right);
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String getSymbol() {
        return "+";
    }

    @Override
    public <T extends Number> T calculate(T x, T y, AbstractCalculator<T> calculator) {
        return calculator.add(x, y);
    }

    @Override
    public boolean needsExtraBrackets() {
        return false;
    }
}
