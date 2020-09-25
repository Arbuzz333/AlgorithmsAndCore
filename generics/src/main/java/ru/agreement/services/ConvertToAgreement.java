package ru.agreement.services;


import org.springframework.stereotype.Service;
import ru.agreement.entities.Agreement;
import ru.agreement.entities.AgricultureAgreement;
import ru.agreement.entities.MortgageAgreement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class ConvertToAgreement {

    public List<Agreement> toAgreementExtendsWildcard(List<Agreement> agreements, List<MortgageAgreement> mortgageAgreements) {
        List<Agreement> target = new ArrayList<>();

        List<? extends Agreement> agreementWildcards;
        List<? extends MortgageAgreement> agreementWildcardsMortgage;

        /*
        «Дженерики» инвариантны.
        compile-time error. Проблема обнаружилась на этапе компиляции

        target = mortgageAgreements;
        */

        agreementWildcards = agreements;
//        agreementWildcards = mortgageAgreements;
        agreementWildcardsMortgage = mortgageAgreements;

        /*
        В список нельзя ничего добавить, кроме null

        agreementWildcards.add(null);
        agreementWildcardsMortgage.add(null);

        compile-time error
        agreementWildcards.addAll(agreements);
        agreementWildcardsMortgage.addAll(mortgageAgreements);

         */

        target.addAll(agreementWildcards);
        target.addAll(agreementWildcardsMortgage);

        return target;
    }

    public List<Agreement> toAgreementSuperWildcard(List<Agreement> agreements, List<MortgageAgreement> mortgageAgreements, List<AgricultureAgreement> agricultureAgreements) {
        List<Agreement> target = new ArrayList<>();

        List<? super Agreement> agreementWildcards = new ArrayList<>();
        List<? super MortgageAgreement> agreementWildcardsMortgage = new ArrayList<>();

//        agreementWildcards = agreements;
        agreementWildcards.addAll(agreements);
//        agreementWildcards.add(mortgageAgreements.get(0));
        agreementWildcards.addAll(mortgageAgreements);
        agreementWildcards.addAll(agricultureAgreements);

        agreementWildcardsMortgage = mortgageAgreements;
        agreementWildcardsMortgage.addAll(mortgageAgreements);
        agreementWildcardsMortgage.addAll(agricultureAgreements);

        /*
        Нельзя прочитать элемент из контейнера с wildcard ? super, кроме объекта класса Object

        compile-time error
        agreementWildcardsMortgage.addAll(agreements);
        agreementWildcards.addAll(agreementWildcardsMortgage);

        target.addAll(agreementWildcards);
        target.addAll(agreementWildcardsMortgage);

         */

        target = toListFromSuperWildcard(agreementWildcards);

        return target;
    }

    private List<Agreement> toListFromSuperWildcard(List<? super Agreement> superAgreements) {
        ArrayList<Agreement> collect = superAgreements.stream()
                .filter(a -> a instanceof Agreement)
                .map(a -> (Agreement) a)
                .collect(Collectors.toCollection(ArrayList::new));

        return collect;
    }

}
