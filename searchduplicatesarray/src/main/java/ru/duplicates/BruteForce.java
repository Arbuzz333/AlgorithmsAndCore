package ru.duplicates;


public class BruteForce implements SearchDuplicateArray {

    /*O(n²) — временная сложность и O(1) — пространственная сложность.*/
    public int[] searchDuplicates(int[] array) {

        int[] buffer = new int[array.length];
        int index = 0;
        int[] indicator = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int count = 0;

            for (int j = 0; j < array.length; j++) {
                if (i != j && indicator[i] != -1) {
                    if (indicator[j] != -1 && array[i] == array[j]) {
                        indicator[j] = -1;
                        ++count;
                        if (count == 1) {
                            buffer[index++] = array[i];
                        }
                    }
                }
            }
            if (count > 0) {
                indicator[i] = -1;
            }
        }
        return cutArray(index, buffer);
    }
}
