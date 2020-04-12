package expression.generic.calculators;

public class FloatCalculator extends AbstractCalculator<Float> {
    public static final String MODE = "f";

    @Override
    public Float add(Float x, Float y) {
        return x + y;
    }

    @Override
    public Float subtract(Float x, Float y) {
        return x - y;
    }

    @Override
    public Float multiply(Float x, Float y) {
        return x * y;
    }

    @Override
    public Float divide(Float x, Float y) {
        return x / y;
    }

    @Override
    public Float negate(Float x) {
        return -x;
    }

    @Override
    public Float count(Float x) {
        return (float) Integer.bitCount(Float.floatToIntBits(x));
    }

    @Override
    public int compareTo(Float x, Float y) {
        return x.compareTo(y);
    }

    @Override
    public Float get(String x) {
        return Float.parseFloat(x);
    }

    @Override
    public Float get(int x) {
        return (float) x;
    }
}
