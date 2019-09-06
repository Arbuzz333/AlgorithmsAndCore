package ru.sberbank.service;

import ru.sberbank.entity.Element;

import java.util.List;

public interface SearchElements {

    List<Element> searchNeighboringCoordinatesByVector(Element[][] elements, Element element);
}
