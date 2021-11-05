import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1. Разработка через тестирование");
        System.out.println("Кредитный калькулятор");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму кредита");
        final int sum = scanner.nextInt();

        System.out.println("Введите годовую процентную ставку");
        final int percent = scanner.nextInt();

        System.out.println("Введите срок в месяцах");
        final int month = scanner.nextInt();

        double payment = LoanCalculator.calculateCalendar(month, sum, percent);

        double yearPercent = 1 + (((double) percent) / 100);
        double monthPercent = Math.pow(yearPercent, 1.0 / 12) -1;

        double balance = sum;

        System.out.printf("payment %.4f\n", payment);
        System.out.println("Месяц | платеж | Проценты | погашение | остаток");

        System.out.printf("%d     | %.2f   | %.2f     | %.2f      | %.2f \n", 1, 0.0, 0.0, 0.0, balance);

        for (int i = 1; i < month; i++) {
            double oldSum = balance;
            balance = balance * (monthPercent + 1);
            double percents = balance - oldSum;
            balance -= payment;
            double body = payment - percents;

            System.out.printf("%d     | %.2f   | %.2f     | %.2f      | %.2f \n", i + 1, payment, percents, body, balance);
        }
    }
}
