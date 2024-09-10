package grigory.vacationcalculator.controller;

import org.springframework.web.bind.annotation.*;
import grigory.vacationcalculator.model.VacationRequest;
import grigory.vacationcalculator.service.VacationCalculatorService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/calculate")
public class VacationCalculatorController {

    private final VacationCalculatorService vacationCalculatorService;

    public VacationCalculatorController(VacationCalculatorService vacationCalculatorService) {
        this.vacationCalculatorService = vacationCalculatorService;
    }

    @GetMapping
    public double calculateVacation(@RequestParam double averageSalary,
                                    @RequestParam int vacationDays,
                                    @RequestParam(required = false) List<LocalDate> vacationDates) {
        VacationRequest vacationRequest = new VacationRequest(averageSalary, vacationDays, vacationDates);
        return vacationCalculatorService.calculate(vacationRequest);
    }
}
