package calculator;

public class SubtractOperator implements Operator {

    @Override
    public double operate(double num1, double num2) throws CalculatorException {
        return num1 - num2;
    }
}
