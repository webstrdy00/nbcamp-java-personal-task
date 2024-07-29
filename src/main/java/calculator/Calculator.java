package calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CalculatorException extends  Exception{      // 사용자정의 예외 클래스
    public CalculatorException(String message){
        super(message);
    }
}
public abstract class Calculator {

    protected List<Double> results;    // 다른 클래스에서 사용해야함으로 private가 아닌 protected로 지정
    protected Map<Character, Operator> operators;  // 사칙연산 구분을 위한 리스트생성

    public Calculator(){    // 생성자
        this.results = new ArrayList<>();
        this.operators = new HashMap<>();   // HashMap()으로 생성
    }

    public List<Double> getResults(){     // 저장된 모든 결과값을 가져가는 메서드
        return new ArrayList<>(results);
    }    // 연산 결과들을 가져오는 메서드

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

    public void printResults(){    // 저장된 계산 결과들을 프린트하는 메서드
        if (results.isEmpty()){
            System.out.println("저장된 결과가 없습니다.");
        }else {
            System.out.println("저장된 연산 결과");
            int index = 1;
            for (double result : results){
                System.out.println(index+"번째 결과는 "+result+"입니다.");
                index++;
            }
            System.out.println( );
        }
    }
    public abstract double calculate(double... params) throws CalculatorException;     // 추상클래스로 작성
}
