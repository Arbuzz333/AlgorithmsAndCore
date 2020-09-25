package ru.agreement.entities;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Component
public class EntitiesGenerator {

    public List<Agreement> generateAgreement() {
        Calendar calendarSeventeen = Calendar.getInstance();
        calendarSeventeen.set(2017, Calendar.JUNE, 25);

        Calendar calendarEighteen = Calendar.getInstance();
        calendarSeventeen.set(2018, Calendar.OCTOBER, 15);

        MortgageAgreement mortgageAgreementEleven =
                new MortgageAgreement(
                        "111",
                        calendarSeventeen,
                        new BigDecimal(5000),
                        Pledge.INDUSTRIAL);

        AgricultureAgreement agricultureAgreementTwelve =
                new AgricultureAgreement(
                        "212",
                        calendarEighteen,
                        new BigDecimal(7000),
                        Pledge.APARTMENT, AgricultureType.ANIMAL_HUSBANDRY);

        return List.of(mortgageAgreementEleven, agricultureAgreementTwelve);
    }

    public List<MortgageAgreement> generateMortgageAgreement() {
        Calendar calendarTwentyThree = Calendar.getInstance();
        calendarTwentyThree.set(2003, Calendar.DECEMBER, 23);

        Calendar calendarFourtyFour = Calendar.getInstance();
        calendarTwentyThree.set(2004, Calendar.APRIL, 14);

        MortgageAgreement mortgageAgreementTwentyThree =
                new MortgageAgreement(
                        "223",
                        calendarTwentyThree,
                        new BigDecimal(2300),
                        Pledge.APARTMENT);
        MortgageAgreement mortgageAgreementThirtySeven =
                new MortgageAgreement(
                        "434",
                        calendarFourtyFour,
                        new BigDecimal(4400),
                        Pledge.INDUSTRIAL);
        return buildList(mortgageAgreementTwentyThree, mortgageAgreementThirtySeven);
    }

    public List<AgricultureAgreement> generateAgricultureAgreement() {
        Calendar calendarFifteen = Calendar.getInstance();
        calendarFifteen.set(2015, Calendar.FEBRUARY, 5);

        Calendar calendarTwelve = Calendar.getInstance();
        calendarFifteen.set(2012, Calendar.MARCH, 12);

        AgricultureAgreement agricultureAgreementFifteen =
                new AgricultureAgreement(
                        "515",
                        calendarFifteen,
                        new BigDecimal(1500),
                        Pledge.RETAIL, AgricultureType.CROP_PRODUCTION);

        AgricultureAgreement agricultureSeventyFive =
                new AgricultureAgreement(
                        "575",
                        calendarTwelve,
                        new BigDecimal(7500),
                        Pledge.APARTMENT, AgricultureType.ANIMAL_HUSBANDRY);

        return buildList(agricultureAgreementFifteen, agricultureSeventyFive);
    }

    private <T> List<T> buildList(T first, T second) {
        List<T> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        return list;
    }

}
