package ru.duplicates;




public interface SearchDuplicateArray {

    int[] searchDuplicates(int[] array);

    default int[] cutArray(int index, int[] buffer) {
        int[] result = new int[index];
        if (index >= 0) System.arraycopy(buffer, 0, result, 0, index);
        return result;
    }

}
