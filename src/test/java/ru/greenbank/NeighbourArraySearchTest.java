package ru.greenbank;


import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.greenbank.create.FillElementsArray;
import ru.greenbank.entity.Element;
import ru.greenbank.service.SearchElements;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;




@ContextConfiguration(classes = CommonSearchConfig.class)
@ExtendWith(SpringExtension.class)
public class NeighbourArraySearchTest {

    private final Logger logger = Logger.getLogger("NeighbourArraySearchTest");

    @Autowired
    CommonSearch commonSearch;

    @Autowired
    private FillElementsArray array;

    @Autowired
    private SearchElements searchElements;

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

    /* Тест для массива размером size = 9 и для элемента x = 0 y = 8
     * Зполнение массива через сервис FillElementsArray*/
    @DisplayName("Test with @ArgumentsSource")
    @ParameterizedTest
    @ArgumentsSource(ExpectedListLeftTop.class)
    public void commonSearchTestArrayLeftTop(List<Element> elementsExpectedLeftTop) {
        Element[][] elements1FromStream = array.fillingByStream();

        List<Element> elements = searchElements.searchNeighboringCoordinatesByVector(elements1FromStream, new Element(0, 8));
        Assert.assertEquals(3, elements.size());
        Assert.assertEquals(elementsExpectedLeftTop, elements);
        logger.info(elements.toString());
    }

    /* <{0, 8}> {1, 8}*/
    /* {0, 7}  {1, 7}*/
    static class ExpectedListLeftTop implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new ArrayList<Element>(3) {
                        {
                            add(new Element(1, 8));
                            add(new Element(1, 7));
                            add(new Element(0, 7));
                        }
                    })
            );
        }
    }

}
