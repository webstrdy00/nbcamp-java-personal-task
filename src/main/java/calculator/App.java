package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;

        while (true){   // while문을 통해 반복 실행
            System.out.print("첫 번째 숫자를 입력 (종료 : 'exit') ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("exit")){   // input이 exit일 경우 프로그램 종료
                System.out.println("프로그램이 종료됩니다.");
                break;
            }

            int num1;  
            try {       // 첫번째 숫자 저장 과정
                num1 = Integer.valueOf(input);
            }catch (NumberFormatException e){
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
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    }else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("올바른 사칙연산 기호를 입력하세요.");
                    break;
            }

            System.out.println("계산 결과는 "+result+"입니다.");
            result = 0;
        }
    }
}
