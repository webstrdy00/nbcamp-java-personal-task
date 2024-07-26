package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true){   // while문을 통해 반복 실행
            System.out.print("첫 번째 숫자를 입력 (종료 : 'exit', 첫 번째 결과 삭제 : 'remove', 모든 결과 출력 : 'inquiry') ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("exit")) {   // input이 exit일 경우 프로그램 종료
                System.out.println("프로그램이 종료됩니다.");
                break;
            }
             else if (input.equalsIgnoreCase("remove")) { //  input이 remove일 경우 가장 먼저 저장된 결과 삭제
                calculator.removeFirstResult();
                continue;
            } else if (input.equalsIgnoreCase("inquiry")){ //  input이 inquiry 경우 저장된 연산 결과 전부를 출력
                calculator.printResults();
                continue;
            }

            int num1;  
            try {       // 첫번째 숫자 저장 과정
                num1 = Integer.valueOf(input);
            }catch (NumberFormatException e){    // 숫자가 아닐경우 오류 처리
                System.out.println("올바른 숫자를 입력하세요.");
                continue;
            }

            System.out.print("두 번쨰 숫자를 입력 : ");
            input = scanner.next();
            int num2;  
            try {       // 두번쨰 숫자 저장 과정
                num2 = Integer.valueOf(input);
            }catch (NumberFormatException e){
                System.out.println("올바른 숫자를 입력하세요.");
                continue;
            }

            System.out.print("사칙연산 기호를 입력 ('+', '-', '*', '/') ");
            char operator = scanner.next().charAt(0);  // 사칙연산 저장

            try {       // 계산과정 Calculator클래스 적용
                int result = calculator.calculate(num1, num2, operator);
                System.out.printf("%d %c %d = %d\n",num1,operator,num2,result);
                System.out.println("결과가 저장되었습니다. (저장된 결과 개수 "+calculator.getResults().size()+")");
            }catch (CalculatorException e){
                System.out.println("계산 오류 : "+e.getMessage());
            }

            System.out.println( ); // 계산후 빈 줄 추가
        }
        System.out.println("사칙연산 결과: ");
        calculator.printResults();
        scanner.close();
    }
}
