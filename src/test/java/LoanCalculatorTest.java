import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LoanCalculatorTest {

    @ParameterizedTest
    @MethodSource("mySource")
    void calculateCalendar(int month, int sum, int percent) {
        double payment = LoanCalculator.calculateCalendar(month, sum, percent);

        double monthPercent = Math.pow((double) percent, 1.0 / 12);

        double balance = (double) sum;
        for (int i = 1; i < month; i++) {
            double oldSum = balance;
            balance = balance * monthPercent;
            double percents = balance - oldSum;
            balance -= payment;
            double telo = payment - percents;

            //System.out.printf("%d. pay = %.2f --- percents = %.2f --- telo = %.2f  --- ost = %.2f \n", i, payment, percents, telo, balance);
        }
        assertEquals(balance, 0);
    }

    static Stream<Arguments> mySource() {
        return Stream.of(
                Arguments.arguments(60, 100_000,  10),
                Arguments.arguments(60, 100_000,  15),
                Arguments.arguments(24, 500_000,  20)
        );
    }
}