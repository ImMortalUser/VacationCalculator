package grigory.vacationcalculator.service;

import org.springframework.stereotype.Service;
import grigory.vacationcalculator.model.VacationRequest;
import grigory.vacationcalculator.util.HolidayUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class VacationCalculatorService {

    private static final int WORK_DAYS_PER_MONTH = 21;

    public double calculate(VacationRequest request) {
        List<LocalDate> vacationDates = request.getVacationDates();
        if (vacationDates != null && !vacationDates.isEmpty()) {
            return calculateVacationPayWithDates(request);
        } else {
            return calculateVacationPay(request);
        }
    }

    private double calculateVacationPay(VacationRequest request) {
        return (request.getAverageSalary() / WORK_DAYS_PER_MONTH) * request.getVacationDays();
    }

    private double calculateVacationPayWithDates(VacationRequest request) {
        List<LocalDate> vacationDates = request.getVacationDates();
        long validDays = vacationDates.stream()
                .filter(date -> date.getDayOfWeek() != DayOfWeek.SATURDAY
                        && date.getDayOfWeek() != DayOfWeek.SUNDAY
                        && !HolidayUtil.isHoliday(date))
                .count();
        return (request.getAverageSalary() / WORK_DAYS_PER_MONTH) * validDays;
    }
}
