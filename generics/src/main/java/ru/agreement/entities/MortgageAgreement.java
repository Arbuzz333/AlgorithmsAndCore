package ru.agreement.entities;

import java.math.BigDecimal;
import java.util.Calendar;



public class MortgageAgreement extends Agreement {

    private Pledge pledge;

    public MortgageAgreement(String number, Calendar startDate, BigDecimal sum, Pledge pledge) {
        super(number, startDate, sum);
        this.pledge = pledge;
    }

    public Pledge getPledge() {
        return pledge;
    }
}
