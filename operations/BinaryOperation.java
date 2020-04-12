package expression.operations;

import expression.CommonExpression;
import expression.Expression;
import expression.generic.calculators.AbstractCalculator;

import java.util.Objects;

public abstract class BinaryOperation extends CommonExpression {
    private final CommonExpression left;
    private final CommonExpression right;

    public BinaryOperation(CommonExpression left, CommonExpression right) {
        this.left = left;
        this.right = right;
    }

    public abstract int getPriority();

    public abstract String getSymbol();

    public abstract <T extends Number> T calculate(T x, T y, AbstractCalculator<T> calculator);

    public abstract boolean needsExtraBrackets();

    @Override
    public <T extends Number> T evaluate(T x, AbstractCalculator<T> calculator) {
        T leftValue = left.evaluate(x, calculator);
        T rightValue = right.evaluate(x, calculator);
        return calculate(leftValue, rightValue, calculator);
    }

    @Override
    public <T extends Number> T evaluate(T x, T y, T z, AbstractCalculator<T> calculator) {
        T leftValue = left.evaluate(x, y, z, calculator);
        T rightValue = right.evaluate(x, y, z, calculator);
        return calculate(leftValue, rightValue, calculator);
    }

    @Override
    public String toString() {
        return addBrackets(left + " " + getSymbol() + " " + right, true);
    }

    private boolean checkBrackets(Expression expression) {
        return expression instanceof BinaryOperation
                && ((BinaryOperation) expression).getPriority() > getPriority();
    }

    private boolean checkExtraBrackets(Expression expression) {
        if (expression instanceof BinaryOperation) {
            BinaryOperation binaryOperation = (BinaryOperation) expression;
            return binaryOperation.getPriority() == getPriority() &&
                    (this.needsExtraBrackets() || binaryOperation.needsExtraBrackets());
        }
        return false;
    }

    @Override
    public String toMiniString() {
        return addBrackets(left.toMiniString(), checkBrackets(left)) +
                " " + getSymbol() + " " +
                addBrackets(right.toMiniString(), checkBrackets(right) || checkExtraBrackets(right));
    }

    private String addBrackets(String expression, boolean condition) {
        return condition ? "(" + expression + ")" : expression;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BinaryOperation) {
            BinaryOperation binaryOperation = (BinaryOperation) obj;
            return this.getClass() == binaryOperation.getClass()
                    && Objects.equals(left, binaryOperation.left)
                    && Objects.equals(right, binaryOperation.right);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, getClass());
    }
}
