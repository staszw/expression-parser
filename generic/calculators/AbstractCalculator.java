package expression.generic.calculators;

public abstract class AbstractCalculator<T extends Number> {
    public abstract T add(T x, T y);
    public abstract T subtract(T x, T y);
    public abstract T multiply(T x, T y);
    public abstract T divide(T x, T y);
    public abstract T negate(T x);
    public abstract T count(T x);
    public abstract int compareTo(T x, T y);
    public abstract T get(String x);
    public abstract T get(int x);
}
