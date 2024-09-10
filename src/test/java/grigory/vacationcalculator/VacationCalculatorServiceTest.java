package grigory.vacationcalculator;

import org.junit.jupiter.api.Test;
import grigory.vacationcalculator.model.VacationRequest;
import grigory.vacationcalculator.service.VacationCalculatorService;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacationCalculatorServiceTest {

    private final VacationCalculatorService vacationCalculatorService = new VacationCalculatorService();

    @Test
    public void testCalculateVacationPay() {
        VacationRequest request = new VacationRequest(60000, 10, null);
        double result = vacationCalculatorService.calculate(request);
        assertEquals(28571.43, result, 0.01);
    }

    @Test
    public void testCalculateVacationPayWithDates() {
        VacationRequest request = new VacationRequest(60000, 0, Arrays.asList(
                LocalDate.of(2024, 9, 1),
                LocalDate.of(2024, 9, 2),
                LocalDate.of(2024, 9, 3),
                LocalDate.of(2024, 9, 4),
                LocalDate.of(2024, 9, 5)
        ));
        double result = vacationCalculatorService.calculate(request);
        assertEquals(11428.57, result, 0.01);
    }
}
