package ru.agreement.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import ru.agreement.AgreementConfig;
import ru.agreement.entities.Agreement;
import ru.agreement.entities.EntitiesGenerator;
import org.junit.Assert;

import java.util.List;


@ContextConfiguration(classes = AgreementConfig.class)
public class ConvertToAgreementTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private ConvertToAgreement convertToAgreement;

    @Autowired
    private EntitiesGenerator generator;

    @Test
    public void toAgreementExtendsWildcard() {
        List<Agreement> agreements = convertToAgreement.toAgreementExtendsWildcard(generator.generateAgreement(), generator.generateMortgageAgreement());
        Assert.assertEquals(agreements.size(), 4);
    }

    @Test
    public void toAgreementSuperWildcard() {
        List<Agreement> agreements = convertToAgreement.toAgreementSuperWildcard(
                generator.generateAgreement(),
                generator.generateMortgageAgreement(),
                generator.generateAgricultureAgreement());

        Assert.assertEquals(agreements.size(), 6);
    }
}