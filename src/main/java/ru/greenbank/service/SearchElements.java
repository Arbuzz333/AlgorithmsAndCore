package ru.greenbank.service;

import ru.greenbank.entity.Element;

import java.util.List;

public interface SearchElements {

    List<Element> searchNeighboringCoordinatesByVector(Element[][] elements, Element element);
}
