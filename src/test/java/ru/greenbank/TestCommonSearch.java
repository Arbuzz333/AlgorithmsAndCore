package ru.greenbank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import ru.greenbank.create.FillElementsArray;
import ru.greenbank.entity.Element;
import ru.greenbank.service.SearchElements;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



@ContextConfiguration(classes = CommonSearchConfig.class)
public class TestCommonSearch extends AbstractJUnit4SpringContextTests {

    @Autowired
    CommonSearch search;

    @Autowired
    private FillElementsArray array;

    @Autowired
    private SearchElements searchElements;

    @Value("${x}")
    private int x;

    @Value("${y}")
    private int y;

    /* {1, 4} {2, 4} {3, 4}*/
    /* {1, 3}*{2, 3}*{3, 3}*/
    /* {1, 2} {2, 2} {3, 2}*/
    private List<Element> elementsExpectedDefault;

    /* {0, 1} <{1, 1}>*/
    /* {0, 0}  {1, 0}*/
    private List<Element> elementsExpectedTwoSize;

    @Before
    public void expectedListFromDefaultProperties() {
        elementsExpectedDefault = new ArrayList<Element>(8) {
            {
                add(new Element(1, 2));
                add(new Element(1, 3));
                add(new Element(1, 4));
                add(new Element(2, 4));
                add(new Element(3, 4));
                add(new Element(3, 3));
                add(new Element(3, 2));
                add(new Element(2, 2));

            }};
        elementsExpectedTwoSize = new ArrayList<Element>(3) {
            {
                add(new Element(0, 0));
                add(new Element(0, 1));
                add(new Element(1, 0));
            }};
    }

    /* Зполнение массива через сервис FillElementsArray
    * Тест для size = 9, x = 2, y = 3
    * эти значения бурутся из application.properties*/
    @Test
    public void commonSearchTestArrayFromStream() {
        Element[][] elements1FromStream = array.fillingByStream();

        List<Element> elements = searchElements.searchNeighboringCoordinatesByVector(elements1FromStream, new Element(x, y));
        Assert.assertEquals(8, elements.size());
        Assert.assertEquals(elementsExpectedDefault, elements);
        logger.info(elements.toString());
    }

    /* Тест для size = 2 x = 1, y = 1*/
    @Test
    public void commonSearchTestArrayTwoSize() {
        Element[][] elements1FromStream = array.fillingByStreamSize(2);

        List<Element> elements = searchElements.searchNeighboringCoordinatesByVector(elements1FromStream, new Element(1, 1));
        Assert.assertEquals(3, elements.size());
        Assert.assertEquals(elementsExpectedTwoSize, elements);
        logger.info(elements.toString());
        logger.info(Stream.of(elements1FromStream)
                .map(rowParts -> Stream.of(rowParts)
                        .map(Element::toString)
                        .collect(Collectors.joining("\t")))
                        .collect(Collectors.joining("\n")));
    }

}
