package expression.generic.calculators;

public class IntegerCalculator extends AbstractCalculator<Integer> {
    public static final String MODE = "u";

    @Override
    public Integer add(Integer x, Integer y) {
        return x + y;
    }

    @Override
    public Integer subtract(Integer x, Integer y) {
        return x - y;
    }

    @Override
    public Integer multiply(Integer x, Integer y) {
        return x * y;
    }

    @Override
    public Integer divide(Integer x, Integer y) {
        return x / y;
    }

    @Override
    public Integer negate(Integer x) {
        return -x;
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
