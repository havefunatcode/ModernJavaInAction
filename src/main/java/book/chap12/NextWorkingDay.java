package book.chap12;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextWorkingDay implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int amountToAdd = 1;
        if (dayOfWeek == DayOfWeek.FRIDAY) {
            amountToAdd = 3;
        } else if (dayOfWeek == DayOfWeek.SATURDAY) {
            amountToAdd = 2;
        }
        return temporal.plus(amountToAdd, ChronoUnit.DAYS);
    }
}
