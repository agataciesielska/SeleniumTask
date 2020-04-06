package utils;

import java.time.LocalDate;

public class DatePicker {

    public LocalDate getTodayDate() {
        return LocalDate.now();
    }

    public LocalDate getDateInGivenWeeks(int numberOfWeeks) {
        return getTodayDate().plusWeeks(numberOfWeeks);
    }

}
