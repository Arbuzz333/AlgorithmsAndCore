package ru.duplicates;




public class BySortedArray implements SearchDuplicateArray{

    /*
    * Пространственная сложность O(1), но временная O(n log(n)), так как нам нужно отсортировать коллекцию.*/
    public int[] searchDuplicates(final int[] array) {
        if (array.length <= 1) {
            return new int[0];
        }

        int[] buffer = new int[array.length];
        int index = 0;

        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);

        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                if (!flag) {
                    buffer[index++] = array[i];
                    flag = true;
                }
            } else {
                flag = false;
            }
        }

        return cutArray(index, buffer);
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}
