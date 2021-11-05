import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanCalculatorTest {

    @ParameterizedTest
    @MethodSource("mySource")
    void calculateCalendar(int month, int sum, int percent) {
        double payment = LoanCalculator.calculateCalendar(month, sum, percent);

        double yearPercent = 1 + (((double) percent) / 100);
        double monthPercent = Math.pow(yearPercent, 1.0 / 12) ;

        double balance = sum;
        for (int i = 1; i < month; i++) {
            balance = balance * (monthPercent);
            balance -= payment;
        }
        assertEquals(Math.round(balance), 0);
    }

    static Stream<Arguments> mySource() {
        return Stream.of(
                Arguments.arguments(60, 100_000,  10),
                Arguments.arguments(60, 100_000,  15),
                Arguments.arguments(24, 500_000,  20)
        );
    }
}