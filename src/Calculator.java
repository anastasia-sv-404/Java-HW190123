import java.util.Arrays;
import java.util.Scanner;

//Реализовать простой калькулятор ("введите первое число"... "Введите второе число"... "укажите операцию, которую надо выполнить с этими числами"... "ответ: ...")
public class Calculator {
    public static void main(String[] args) {
        Scanner zeroScanner = new Scanner(System.in);

        while (true) {
            double x = checkNumber();
            String oper = checkOperation();
            double y = checkNumber();
            double res = 0;

            if (oper.equals("+")) {
                res = getSum(x, y);
                printResult(x, oper, y, res);
            } else if (oper.equals("-")) {
                res = getDeduction(x, y);
                printResult(x, oper, y, res);
            } else if (oper.equals("*")) {
                res = getMultiplicatin(x, y);
                printResult(x, oper, y, res);
            } else {
                if (y != 0) {
                    res = getDivision(x, y);
                    printResult(x, oper, y, res);
                } else {
                    System.out.print("На 0 делить нельзя!");
                }
            }
            System.out.println();

            if (Main_fin.anotherAction() != 1) {
                System.out.println("Спасибо, до свидания!");
                break;
            }
        }
    }

    static double checkNumber() {
        double num = 0;

        while (true) {
            Scanner firstScanner = new Scanner(System.in);
            System.out.print("Введите число: ");
            boolean flag = firstScanner.hasNextDouble();
            if (!flag) {
                System.out.println("Вы ввели неверное значение. Попробуйте еще раз.");
            } else {
                num = firstScanner.nextDouble();
                return num;
            }
        }

    }

    static String checkOperation() {
        String oper = " ";
        String[] operations = new String[]{"+", "-", "/", "*"};

        while (true) {
            Scanner secondScanner = new Scanner(System.in);
            System.out.print("Введите операцию: ");
            oper = secondScanner.nextLine();
            if (Arrays.asList(operations).contains(oper)) {
                return oper;
            } else {
                System.out.println("Вводите одну из следующих операций: '+', '-', '/', '*' .");
            }
        }
    }

    static double getSum(double a, double b) {
        return a + b;
    }

    static double getDeduction(double a, double b) {
        return a - b;
    }

    static double getMultiplicatin(double a, double b) {
        return a * b;
    }

    static double getDivision(double a, double b) {
        return a / b;
    }

    static void printResult(double a, String oper, double b, double res) {
        System.out.printf("%.2f %s %.2f равно %.2f", a, oper, b, res);
    }
}
