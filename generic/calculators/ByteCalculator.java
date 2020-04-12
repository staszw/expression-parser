package expression.generic.calculators;

public class ByteCalculator extends AbstractCalculator<Byte> {
    public static final String MODE = "b";

    @Override
    public Byte add(Byte x, Byte y) {
        return (byte) (x + y);
    }

    @Override
    public Byte subtract(Byte x, Byte y) {
        return (byte) (x - y);
    }

    @Override
    public Byte multiply(Byte x, Byte y) {
        return (byte) (x * y);
    }

    @Override
    public Byte divide(Byte x, Byte y) {
        return (byte) (x / y);
    }

    @Override
    public Byte negate(Byte x) {
        return (byte) -x;
    }

    @Override
    public Byte count(Byte x) {
        return (byte) Integer.bitCount(Byte.toUnsignedInt(x));
    }

    @Override
    public int compareTo(Byte x, Byte y) {
        return x.compareTo(y);
    }

    @Override
    public Byte get(String x) {
        return Byte.parseByte(x);
    }

    @Override
    public Byte get(int x) {
        return (byte) x;
    }
}
