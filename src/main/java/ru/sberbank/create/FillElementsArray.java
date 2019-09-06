package ru.sberbank.create;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.sberbank.entity.Element;

import java.util.stream.IntStream;

@Component
public class FillElementsArray {

    @Value("${size}")
    private int size;

    public Element[][] filling() {
        Element[][]result = new Element[size][size];

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                result[x][y] = new Element(x, y);
            }
        }
        return result;
    }

    public Element[][] fillingByStream() {
        Element[][]result = new Element[size][size];

        result = IntStream.range(0, size).mapToObj(x -> IntStream.range(0, size).mapToObj(y -> new Element(x, y)).toArray(Element[]::new))
                .toArray(Element[][]::new);
        return result;
    }

    public Element[][] fillingByStreamSize(int rate) {
        this.size = rate;
        return fillingByStream();
    }

}
