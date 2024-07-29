package calculator;

public class ArithmeticCalculator extends Calculator{
    public ArithmeticCalculator(){
        super();
        operators.put('+', new AddOperator());
        operators.put('-', new SubtractOperator());
        operators.put('*', new MultiplyOperator());
        operators.put('/', new DivideOperator());
    }
    @Override
    public double calculate(double... params) throws CalculatorException {   // 상속받아 추상클래스구현
        if (params.length != 3)
            throw new CalculatorException("사칙연산에는 두 개의 숫자와 한 개의 연산자가 필요합니다.");

        double num1 = params[0];
        double num2 = params[1];
        char operatorChar = (char) params[2];

        Operator operator = operators.get(operatorChar);   // operatorChar에 맞는 사칙연산을 가져옴
        if (operator == null)
            throw new CalculatorException("올바른 사칙연산 기호를 입력하세요.");

        double result = operator.operate(num1, num2);   // num1, num2이 넘겨줘 사칙연산을 실행

        results.add(result);
        return result;
    }
}
