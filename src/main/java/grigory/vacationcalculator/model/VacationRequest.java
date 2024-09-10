package grigory.vacationcalculator.model;

import java.time.LocalDate;
import java.util.List;

public class VacationRequest {
    private double averageSalary;
    private int vacationDays;
    private List<LocalDate> vacationDates;

    public VacationRequest(double averageSalary, int vacationDays, List<LocalDate> vacationDates) {
        this.averageSalary = averageSalary;
        this.vacationDays = vacationDays;
        this.vacationDates = vacationDates;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public List<LocalDate> getVacationDates() {
        return vacationDates;
    }

    public void setVacationDates(List<LocalDate> vacationDates) {
        this.vacationDates = vacationDates;
    }
}
