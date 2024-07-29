package calculator;

public class ArithmeticCalculator extends Calculator{
    @Override
    public double calculate(double... params) throws CalculatorException {   // 상속받아 추상클래스구현
        if (params.length != 3)
            throw new CalculatorException("사칙연산에는 두 개의 숫자와 한 개의 연산자가 필요합니다.");

        double num1 = params[0];
        double num2 = params[1];
        char operator = (char) params[2];

        double result;
        switch (operator){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0){
                    throw new CalculatorException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                throw new CalculatorException("올바른 사칙연산 기호를 입력하세요.");
        }

        results.add(result);
        return result;
    }
}
