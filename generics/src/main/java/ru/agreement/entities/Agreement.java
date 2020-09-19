package ru.agreement.entities;

import java.math.BigDecimal;
import java.util.Calendar;



public abstract class Agreement {

    private String number;

    private Calendar startDate;

    private BigDecimal sum;

    protected Agreement(String number, Calendar startDate, BigDecimal sum) {
        this.number = number;
        this.startDate = startDate;
        this.sum = sum;
    }

    public String getNumber() {
        return number;

    }

    public Calendar getStartDate() {
        return startDate;
    }

    public BigDecimal getSum() {
        return sum;
    }
}
