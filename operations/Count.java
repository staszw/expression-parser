package expression.operations;

import expression.CommonExpression;
import expression.generic.calculators.AbstractCalculator;

public class Count extends UnaryOperation {
    public Count(CommonExpression inner) {
        super(inner);
    }

    @Override
    public <T extends Number> T calculate(T x, AbstractCalculator<T> calculator) {
        return calculator.count(x);
    }

    @Override
    public String getSymbol() {
        return "count";
    }
}
