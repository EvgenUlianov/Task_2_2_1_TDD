import java.util.*;

public class LoanCalculator {


    public static double  calculateCalendar(int month, int sum, int percent){

        double yearPercent = 1 + (((double) percent) / 100);
        double monthPercent = Math.pow(yearPercent, 1.0 / 12)- 1.0;

        double payment = ((double) sum) * (monthPercent + (monthPercent/(Math.pow(1 + monthPercent, (month - 1)) - 1)));

        return payment;
    }
}
