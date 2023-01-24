import java.util.Scanner;

/*
Реализация первых трех заданий.

Возможности меню (метод main):
1. Проверка правильности ввода номера задания (число от 1 до 3)
2. Возможность запуска каждого из заданий - полсе запуска предыдущего, не перезапуская программу.

Возможности при решении задач:
1. Проверка корректности ввода числа n: целое положительное число.
 */

public class Main_fin {
    public static void main(String[] args) {
        while (true) {

            int ex = checkExcNum();

            if (ex == 1) {
                //Вычислить n-ое треугольного число(сумма чисел от 1 до n)
                int sum = sumN();
                System.out.printf("Сумма чисел от 1 до введенного целого числа:  %d", sum);
            } else if (ex == 2) {
                //Вычислить n! (произведение чисел от 1 до n)
                int multi = factorialN();
                System.out.printf("Произведение чисел от 1 до введенного целого числа (факториал): %d", multi);
            } else if (ex == 3) {
                //Вывести все простые числа от 1 до 1000
                // (простые числа - это числа которые делятся только на себя и на единицу без остатка.
                simpleNum();
            } else {
                System.out.println("Вы ввели неверное значение, попробуйте еще раз.");
            }
            System.out.println();

            if (anotherAction() != 1) {
                System.out.println("Спасибо, до свидания!");
                break;
            }
        }
    }

    static int anotherAction() {
        while (true) {
            Scanner firstScanner = new Scanner(System.in);
            System.out.print("Желаете продолжить? (1 - да, 2 - нет): ");
            if (!firstScanner.hasNextInt()) {
                System.out.println("Вы ввели неверное значение. Попробуйте еще раз.");
            } else {
                int answer = firstScanner.nextInt();
                return answer;
            }

        }
    }

    static int checkExcNum() {
        int ex = 0;

        while (true) {
            Scanner secondScanner = new Scanner(System.in);
            System.out.print("Введите номер задания: ");
            boolean flag = secondScanner.hasNextInt();

            if (!flag) {
                System.out.println("Вы ввели неверное значение. Попробуйте еще раз.");
            } else {
                ex = secondScanner.nextInt();
                if (ex >= 1 && ex <= 3) {
                    return ex;
                } else {
                    System.out.println("Вводите значение от 1 до 3.");
                }
            }
        }
    }

    static int checkInsertNum() {
        int num = 0;

        while (true) {
            Scanner iScanner = new Scanner(System.in);
            System.out.print("Введите целое положительное число: ");
            boolean flag = iScanner.hasNextInt();

            if (!flag) {
                System.out.println("Вы ввели неверное значение. Попробуйте еще раз.");
            } else {
                num = iScanner.nextInt();
                if (num > 0) {
                    return num;
                } else {
                    System.out.println("Число должно быть положительным.");
                }
            }
        }
    }

    static int sumN() {
        int num = checkInsertNum();
        int sum = 0;

        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }

    static int factorialN() {
        int num = checkInsertNum();
        int multi = 1;

        for (int i = 1; i <= num; i++) {
            multi *= i;
        }
        return multi;
    }

    static void simpleNum() {
        int num = checkInsertNum();
        System.out.printf("Ряд простых чисел от 1 до %d - это: ", num);
        System.out.println();
        for (int i = 2; i < num; i++) {
            int count = 0;
            for (int j = 2; j <= i && count <= 1; j++) {
                if (i % j == 0) {
                    ++count;
                }
            }
            if (count <= 1)
                System.out.printf(i + " ");
        }
    }
}
