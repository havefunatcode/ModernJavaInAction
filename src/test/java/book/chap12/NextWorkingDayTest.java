package book.chap12;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.*;

import static org.junit.jupiter.api.Assertions.*;

class NextWorkingDayTest {

    @Test
    void adjustInto() {
        LocalDate localDate = LocalDate.of(2024, 6, 28);
        LocalDate nextDate = localDate.with(new NextWorkingDay());
        assertEquals(nextDate, LocalDate.of(2024, 7, 1));
    }

    @Test
    void usingLambda() {
        TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(temporal -> {
            DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int amountToAdd = 1;
            if (dayOfWeek == DayOfWeek.FRIDAY) {
                amountToAdd = 3;
            } else if (dayOfWeek == DayOfWeek.SATURDAY) {
                amountToAdd = 2;
            }

            return temporal.plus(amountToAdd, ChronoUnit.DAYS);
        });
    }
}
