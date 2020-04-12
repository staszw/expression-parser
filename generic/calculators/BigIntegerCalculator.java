package expression.generic.calculators;

import java.math.BigInteger;

public class BigIntegerCalculator extends AbstractCalculator<BigInteger> {
    public static final String MODE = "bi";

    @Override
    public BigInteger add(BigInteger x, BigInteger y) {
        return x.add(y);
    }

    @Override
    public BigInteger subtract(BigInteger x, BigInteger y) {
        return x.subtract(y);
    }

    @Override
    public BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    @Override
    public BigInteger divide(BigInteger x, BigInteger y) {
        return x.divide(y);
    }

    @Override
    public BigInteger negate(BigInteger x) {
        return x.negate();
    }

    @Override
    public BigInteger count(BigInteger x) {
        return BigInteger.valueOf(x.bitCount());
    }

    @Override
    public int compareTo(BigInteger x, BigInteger y) {
        return x.compareTo(y);
    }

    @Override
    public BigInteger get(String x) {
        return new BigInteger(x);
    }

    @Override
    public BigInteger get(int x) {
        return new BigInteger(String.valueOf(x));
    }
}
