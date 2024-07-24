package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] results = new int[10];   //  연산결과를 저장하는 배열 
        int count = 0;     // 저장된 결과의 개수를 알려주는 변수

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

            int result = 0;

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

            // 연산 결과를 배열에 저장
            if (count < results.length){   // 배열에 저장공간이 남아있으면 저장
                results[count] = result;
                count++;
                System.out.println("결과가 저장되었습니다.");
                System.out.println( );
            }
        }

        // 연산 결과 출력
        for(int i = 0;i< count;i++){
            System.out.println((i+1)+"번째 계산 결과는 "+results[i]+"입니다.");
        }
        scanner.close();
    }
}
