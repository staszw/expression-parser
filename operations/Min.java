package expression.operations;

import expression.CommonExpression;
import expression.generic.calculators.AbstractCalculator;

public class Min extends BinaryOperation {
    public Min(CommonExpression left, CommonExpression right) {
        super(left, right);
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public String getSymbol() {
        return "min";
    }

    @Override
    public <T extends Number> T calculate(T x, T y, AbstractCalculator<T> calculator) {
        if (calculator.compareTo(x, y) <= 0) {
            return x;
        }
        return y;
    }

    @Override
    public boolean needsExtraBrackets() {
        return false;
    }
}
