package ru.duplicates;



public class CountIterations implements SearchDuplicateArray {

    /*Значение индекса n представляет число итераций i+1.
    * Временная сложность этого решения — O(n),
    * но и пространственная — O(n), так как нам требуется дополнительная структура.
    * Плюс надо учесть что есть поиск максимального числа массива, который можно заменить мапой*/
    public int[] searchDuplicates(final int[] array) {
        int[] buffer = new int[array.length];
        int index = 0;

        if (array.length <= 1) {
            return new int[0];
        }

        int max = 0;
        for (int j : array) {
            max = Math.max(max, j);
        }

        int[] count = new int[max + 1];

        for (int n : array) {
            if (count[n] == 1) {
                buffer[index++] = n;
            }
            count[n]++;
        }
        return cutArray(index, buffer);
    }
}
