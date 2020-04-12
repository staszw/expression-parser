package expression;

import expression.generic.calculators.AbstractCalculator;

import java.util.Objects;

public final class Const extends CommonExpression {
    private final int number;

    public Const(String number) {
        this.number = Integer.parseInt(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Const &&
                number == (((Const) obj).number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }


    @Override
    public <S extends Number> S evaluate(S x, AbstractCalculator<S> calculator) {
        return calculator.get(number);
    }

    @Override
    public <S extends Number> S evaluate(S x, S y, S z, AbstractCalculator<S> calculator) {
        return calculator.get(number);
    }
}
