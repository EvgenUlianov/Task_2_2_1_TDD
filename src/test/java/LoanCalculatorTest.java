import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LoanCalculatorTest {

    @Test
    void calculateCalendar() {
        List<Float> payments = LoanCalculator.calculateCalendar(60, 1000, 10);
        Float expected = 3_226.72f;
        assertEquals(payments.get(2), expected);
    }
}