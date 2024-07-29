package calculator;

public interface Operator {    // interface 구현해서 각 사칙연산에 맞게 수정하도록 함
    double operate(double num1, double num2) throws CalculatorException;
}
