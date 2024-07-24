package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력 : ");
        int num1 = scanner.nextInt();  // 첫번째 숫자 저장

        System.out.print("두 번쨰 숫자를 입력 : ");
        int num2 = scanner.nextInt();  // 두번쨰 숫자 저장

        System.out.print("사칙연산 기호를 입력 ('+', '-', '*', '/') ");
        char oprator = scanner.next().charAt(0);  // 사칙연산 저장

        int result = 0;

        switch (oprator){
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
    }
}
