package expression;

import expression.generic.calculators.AbstractCalculator;
import expression.generic.calculators.CheckedIntegerCalculator;

public abstract class CommonExpression implements Expression, expression.TripleExpression {
    public abstract <T extends Number> T evaluate(T x, AbstractCalculator<T> calculator);
    public abstract <T extends Number> T evaluate(T x, T y, T z, AbstractCalculator<T> calculator);

    @Override
    public int evaluate(int x) {
        return evaluate(x, new CheckedIntegerCalculator());
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return evaluate(x, y, z, new CheckedIntegerCalculator());
    }
}
