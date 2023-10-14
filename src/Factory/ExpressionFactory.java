package Factory;

import Model.Complex;
import Enum.Operation;
import Model.ComplexExpression;

public interface ExpressionFactory {
    public ComplexExpression createExpression(Operation operation, Complex[] args);
}
