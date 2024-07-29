package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CircleCalculator circleCalculator = new CircleCalculator();

        while (true){   // while문을 통해 반복 실행
            System.out.print("명령어 입력 ( 사칙연산 : 'calc', 원의 넓이 : 'circle', 결과 출력 : 'inquiry', 결과 삭제 : 'remove', 종료 : 'exit', ) ");
            String command = scanner.next();

            if (command.equalsIgnoreCase("exit")) {   // command가 exit일 경우 프로그램 종료
                System.out.println("프로그램이 종료됩니다.");
                break;
            }
             else if (command.equalsIgnoreCase("calc")) { //  command가 calc 경우 사칙연산 실행
                performCalculation(scanner, arithmeticCalculator);
            } else if (command.equalsIgnoreCase("circle")){ //  command가 circle 경우 원의 넓이 연산 실행
                performCircleCalculation(scanner, circleCalculator);
            } else if (command.equalsIgnoreCase("inquiry")) { // command가 inquiry 경우 모든 연산 결과를 출력
                System.out.print("출력할 결과들을 선택하세요 (사칙연산 : 'calc', 원의 넓이 : 'circle') ");
                String select = scanner.next();
                if (select.equalsIgnoreCase("calc"))
                    arithmeticCalculator.printResults();
                else if (select.equalsIgnoreCase("circle")) {
                    circleCalculator.printResults();
                }
            } else if (command.equalsIgnoreCase("remove")) {
                System.out.print("삭제할 결과들을 선택하세요 (사칙연산 : 'calc', 원의 넓이 : 'circle') ");
                String select = scanner.next();
                if (select.equalsIgnoreCase("calc"))
                    arithmeticCalculator.removeFirstResult();
                else if (select.equalsIgnoreCase("circle")) {
                    circleCalculator.removeFirstResult();
                }
            } else {
                System.out.println("올바른 명령어를 입력하세요.");
            }
            System.out.println( );
        }
        System.out.println("사칙연산 결과: ");
        arithmeticCalculator.printResults();

        System.out.println("원의 넓이 계산 결과: ");
        circleCalculator.printResults();
        scanner.close();
    }

    private static void performCalculation(Scanner scanner, Calculator calculator) {    // 사칙연산을 실행하는 메서드
        System.out.print("첫번째 숫자를 입력하세요. ");
        double num1 = scanner.nextInt();
        System.out.print("두번째 숫자를 입력하세요. ");
        double num2 = scanner.nextInt();
        System.out.print("사칙연산 기호를 입력 ('+', '-', '*', '/', '%') ");
        char operator = scanner.next().charAt(0);

        try {
            double result = calculator.calculate(num1, num2, operator);
            System.out.printf("%.2f %c %.2f = %.2f\n", num1, operator, num2, result);
            System.out.println("결과가 저장되었습니다. (저장된 결과 개수 "+calculator.getResults().size()+")");
        }catch (CalculatorException e){
            System.out.println("계산 오류 : "+e.getMessage());
        }
        System.out.println( );
    }

    private static void performCircleCalculation(Scanner scanner, Calculator calculator) {        // 원의 넓이 계산을 실행하는 메서드
        System.out.print("반지름을 입력해주세요. ");
        double radius = scanner.nextDouble();

        try {
            double result = calculator.calculate(radius);
            System.out.printf("반지름이 %.2f인 원의 넓이: %.2f\n", radius, result);
            System.out.println("결과가 저장되었습니다. (저장된 결과 개수 "+calculator.getResults().size()+")");
        }catch (CalculatorException e){
            System.out.println("계산 오류 : "+e.getMessage());
        }
        System.out.println( );
    }
}
