package calculator;

import java.util.ArrayList;
import java.util.List;
class CalculatorException extends  Exception{      // 사용자정의 예외 클래스
    public CalculatorException(String message){
        super(message);
    }
}
public class Calculator {
    private List<Integer> results;

    public Calculator(){    // 생성자
        this.results = new ArrayList<>();
    }

    public int calculate(int num1, int num2, char operator) throws CalculatorException{     // 계산과정 메서드
        if (num1 < 0 || num2 < 0)   
            throw new CalculatorException("음수는 입력할 수 없습니다.");

        int result;

        switch (operator){   // switch문을 통해 사칙기호에 따라 연산 진행
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
