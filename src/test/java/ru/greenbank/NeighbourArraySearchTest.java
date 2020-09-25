package ru.greenbank;


import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.greenbank.entity.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;




@ContextConfiguration(classes = CommonSearchConfig.class)
@ExtendWith(SpringExtension.class)
public class NeighbourArraySearchTest {

    private Logger logger = Logger.getLogger("NeighbourArraySearchTest");

    @Autowired
    CommonSearch commonSearch;

    /*Тест для size = 9, x = 2, y = 3
    * эти значения бурутся из application.properties*/
    @DisplayName("Test with @MethodSource")
    @ParameterizedTest
    @MethodSource
    void testCommonSearch(List<Element> elementsDefault) {
        List<Element> elements = commonSearch.search();
        Assert.assertEquals(8, elements.size());
        Assert.assertEquals(elementsDefault, elements);
        logger.info(elements.toString());
    }

    static Stream<List<Element>> testCommonSearch() {
        return Stream.of(
                new ArrayList<>(8) {
                    {
                        add(new Element(1, 2));
                        add(new Element(1, 3));
                        add(new Element(1, 4));
                        add(new Element(2, 4));
                        add(new Element(3, 4));
                        add(new Element(3, 3));
                        add(new Element(3, 2));
                        add(new Element(2, 2));

                    }
                }
        );
    }

}
