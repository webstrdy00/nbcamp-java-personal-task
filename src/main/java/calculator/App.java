package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = scanner.nextInt();  // 첫번째 숫자 저장

        System.out.print("두 번쨰 숫자를 입력하세요: ");
        int num2 = scanner.nextInt();  // 두번쨰 숫자 저장

        System.out.print("사칙연산 기호를 입력하세요: ");
        char oprator = scanner.next().charAt(0);  // 사칙연산 저장
    }
}
