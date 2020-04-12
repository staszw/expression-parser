package expression.generic.calculators;

import expression.exceptions.expression_exceptions.DivideByZeroException;
import expression.exceptions.expression_exceptions.OverflowException;

public class CheckedIntegerCalculator extends AbstractCalculator<Integer> {
    public static final String MODE = "i";

    @Override
    public Integer add(Integer x, Integer y) {
        if (y > 0 && Integer.MAX_VALUE - y < x || y < 0 && Integer.MIN_VALUE - y > x) {
            throw new OverflowException();
        }
        return x + y;
    }

    @Override
    public Integer subtract(Integer x, Integer y) {
        if (y > 0 && Integer.MIN_VALUE + y > x || y < 0 && Integer.MAX_VALUE + y < x) {
            throw new OverflowException();
        }
        return x - y;
    }

    @Override
    public Integer multiply(Integer x, Integer y) {
        int result = x * y;
        if (x != 0 && y != 0 && (result / x != y || result / y != x)) {
            throw new OverflowException();
        }
        return result;
    }

    @Override
    public Integer divide(Integer x, Integer y) {
        if (x == Integer.MIN_VALUE && y == -1) {
            throw new OverflowException();
        }
        if (y == 0) {
            throw new DivideByZeroException();
        }
        return x / y;
    }

    @Override
    public Integer negate(Integer x) {
        return subtract(0, x);
    }

    @Override
    public Integer count(Integer x) {
        return Integer.bitCount(x);
    }

    @Override
    public int compareTo(Integer x, Integer y) {
        return x.compareTo(y);
    }

    @Override
    public Integer get(String x) {
        return Integer.parseInt(x);
    }

    @Override
    public Integer get(int x) {
        return x;
    }
}
