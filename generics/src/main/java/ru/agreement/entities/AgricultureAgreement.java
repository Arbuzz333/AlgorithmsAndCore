package ru.agreement.entities;

import java.math.BigDecimal;
import java.util.Calendar;

public class AgricultureAgreement extends MortgageAgreement {

    private AgricultureType agricultureType;

    public AgricultureAgreement(String number, Calendar startDate, BigDecimal sum, Pledge pledge, AgricultureType agricultureType) {
        super(number, startDate, sum, pledge);
        this.agricultureType = agricultureType;
    }

    public AgricultureType getAgricultureType() {
        return agricultureType;
    }
}
