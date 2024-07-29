package calculator;

public class CircleCalculator extends Calculator{
    private static final double PI = 3.14159;      // static final를 이용해서 상수로 PI를 정의


    @Override
    public double calculate(double... params) throws CalculatorException {      // 상속받아서 추상클래스 구현
        if (params.length != 1)
            throw new CalculatorException("원의 넓이 계산에는 반지름 한개만 필요합니다.");

        double radius = params[0];
        if (radius <0)
            throw new CalculatorException("반지름은 음수일 수 업습니다.");

        double result;
        result = PI * radius * radius;

        results.add(result);
        return result;
    }
}
