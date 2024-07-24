package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> results = new ArrayList<Integer>();   //  연산결과를 무한히 저장하는 배열

        while (true){   // while문을 통해 반복 실행
            System.out.print("첫 번째 숫자를 입력 (종료 : 'exit', 첫 번째 결과 삭제 : 'remove') ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("exit")) {   // input이 exit일 경우 프로그램 종료
                System.out.println("프로그램이 종료됩니다.");
                break;
            } else if (input.equalsIgnoreCase("remove")) { //  input이 remove일 경우 가장 먼저 저장된 결과 삭제
                if (!results.isEmpty()){   // 배열이 비어있지 않을경우
                    int removeResult = results.remove(0);   // 가장 먼저 저장된 결과 삭제
                    System.out.println("가장 먼저 저장된 결과 " + removeResult+ "가 삭제되었습니다.");
                    System.out.println( );
                    continue;
                }else{   // 배열이 비어있을 경우
                    System.out.println("삭제할 결과가 없습니다.");
                    System.out.println( );
                    continue;
                }

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

            int result = 0;
            boolean validOperation  = true;

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
                        validOperation = false;
                    }else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("올바른 사칙연산 기호를 입력하세요.");
                    validOperation = false;
                    break;
            }

            // 연산 결과를 배열에 저장
            if(validOperation){
                results.add(result);
                System.out.println("결과가 저장되었습니다. (저장된 결과 개수: "+results.size()+")");

            }
            System.out.println( ); // 계산후 빈 줄 추가
        }

        // 연산 결과 출력
        for(int i = 0;i< results.size();i++){
            System.out.println((i+1)+"번째 계산 결과는 "+results.get(i)+"입니다.");
        }
        scanner.close();
    }
}
