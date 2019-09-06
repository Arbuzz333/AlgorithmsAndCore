package ru.sberbank.service.impl;

import org.springframework.stereotype.Service;
import ru.sberbank.entity.Element;
import ru.sberbank.service.SearchElements;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchElementsImpl implements SearchElements {

    private static final int[][] VECTOR = new int[][]{{-1 ,-1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    @Override
    public List<Element> searchNeighboringCoordinatesByVector(Element[][] elements, Element element) {
        List<Element> result = new ArrayList<>();
        for (int[] cell : VECTOR) {
            int x = element.getX() + cell[0];
            int y = element.getY() + cell[1];
            if(x >= 0 && x < elements.length)
                if(y >= 0 && y < elements[x].length)
                    if (elements[x][y] != null ) {
                        result.add(elements[x][y]);
                    }
        }
        return result;
    }
}
