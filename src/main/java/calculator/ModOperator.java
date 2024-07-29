package calculator;

public class ModOperator implements Operator {
    @Override
    public double operate(double num1, double num2) throws CalculatorException {
        if (num2 == 0)
            throw new CalculatorException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        return num1 % num2;
    }
}
