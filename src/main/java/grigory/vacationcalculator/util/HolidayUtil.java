package grigory.vacationcalculator.util;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class HolidayUtil {

    private static final Set<LocalDate> holidays = new HashSet<>();

    static {
        holidays.add(LocalDate.of(2024, 1, 1));
        holidays.add(LocalDate.of(2024, 5, 9));
        holidays.add(LocalDate.of(2024, 1, 7));
        holidays.add(LocalDate.of(2024, 2, 23));
        holidays.add(LocalDate.of(2024, 3, 8));
        holidays.add(LocalDate.of(2024, 6, 12));
        holidays.add(LocalDate.of(2024, 11, 4));
    }

    public static boolean isHoliday(LocalDate date) {
        return holidays.contains(date);
    }
}
