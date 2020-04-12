package expression.generic;

import expression.CommonExpression;
import expression.generic.calculators.*;
import expression.parser.ExpressionParser;

import java.util.Map;

public class GenericTabulator implements expression.generic.Tabulator {
    private static final Map<String, AbstractCalculator<?>> MODE_TO_CALCULATOR = Map.of(
            "i", new CheckedIntegerCalculator(),
            "d", new DoubleCalculator(),
            "bi", new BigIntegerCalculator(),
            "f", new FloatCalculator(),
            "b", new ByteCalculator(),
            "u", new IntegerCalculator()
    );

    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception {
        Object[][][] table = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        CommonExpression parsed = new ExpressionParser().parse(expression);
        AbstractCalculator<?> calculator = MODE_TO_CALCULATOR.get(mode);
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                for (int z = z1; z <= z2; z++) {
                    table[x - x1][y - y1][z - z1] = evaluate(calculator, parsed, x, y, z);
                }
            }
        }
        return table;
    }

    private <T extends Number> T evaluate(AbstractCalculator<T> calculator, CommonExpression expression, int x, int y, int z) {
        try {
            return expression.evaluate(calculator.get(x), calculator.get(y), calculator.get(z), calculator);
        } catch (ArithmeticException e) {
            return null;
        }
    }
}
