package ru.sberbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.sberbank.create.FillElementsArray;
import ru.sberbank.entity.Element;
import ru.sberbank.service.SearchElements;

import java.util.List;

@Service
public class CommonSearch {

    @Autowired
    private FillElementsArray array;

    @Autowired
    private SearchElements searchElements;

    @Value("${x}")
    private int x;

    @Value("${y}")
    private int y;

    public List<Element> search() {
        Element[][] elements = array.filling();
        return searchElements.searchNeighboringCoordinatesByVector(elements, new Element(x, y));
    }

}
