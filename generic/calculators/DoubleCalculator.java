package expression.generic.calculators;


public class DoubleCalculator extends AbstractCalculator<Double> {
    public static final String MODE = "d";

    @Override
    public Double add(Double x, Double y) {
        return x + y;
    }

    @Override
    public Double subtract(Double x, Double y) {
        return x - y;
    }

    @Override
    public Double multiply(Double x, Double y) {
        return x * y;
    }

    @Override
    public Double divide(Double x, Double y) {
        return x / y;
    }

    @Override
    public Double negate(Double x) {
        return -x;
    }

    @Override
    public Double count(Double x) {
        return (double) Long.bitCount(Double.doubleToLongBits(x));
    }

    @Override
    public int compareTo(Double x, Double y) {
        return x.compareTo(y);
    }

    @Override
    public Double get(String x) {
        return Double.parseDouble(x);
    }

    @Override
    public Double get(int x) {
        return (double) x;
    }
}
