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
    public List<Integer> getResults(){     // 저장된 모든 결과값을 가져가는 메서드
        return new ArrayList<>(results);
    }

    public void removeFirstResult(){     // 첫번째로 저장된 결과를 삭제하는 메서드
        if (results.isEmpty()){
            System.out.println("삭제할 값이 없습니다.");
            System.out.println( );
        }else {
            results.remove(0);
            System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
            System.out.println( );
        }
    }

    public void clearResults(){    // 계산 결과들을 모두 제거하는 메서드
        results.clear();
    }

    public void printResults(){    // 저장된 계산 결과들을 보여주는 메서드
        if (results.isEmpty()){
            System.out.println("저장된 결과가 없습니다.");
        }else {
            System.out.println("저장된 연산 결과");
            int index = 1;
            for (int result : results){
                System.out.println(index+"번째 결과는 "+result+"입니다.");
                index++;
            }
            System.out.println( );
        }
    }
}
