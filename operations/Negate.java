package expression.operations;

import expression.CommonExpression;
import expression.generic.calculators.AbstractCalculator;

public final class Negate extends UnaryOperation {

    public Negate(CommonExpression inner) {
        super(inner);
    }

    @Override
    public <T extends Number> T calculate(T x, AbstractCalculator<T> calculator) {
        return calculator.negate(x);
    }


    @Override
    public String getSymbol() {
        return "-";
    }
}
