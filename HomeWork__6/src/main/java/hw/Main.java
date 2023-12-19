package hw;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Вариант 1. со списком
        List<Integer> myList = createList();
        Integer num = createNumber();
        System.out.println(binSearch2(myList, num, 0, myList.size() - 1));

        /* Вариант 2. с массивом
        Integer[] myArray = createArray();
        Integer number = createNumber();
        System.out.println(binSearch(myArray, number, 0, myArray.length - 1));
        System.out.println();
        */
    }

    //метод создания произвольного списка (все значения уникальны)
    public static List<Integer> createList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Integer data = new Random().nextInt(20);
            if (!list.contains(data)) {
                list.add(data);
            }
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(Arrays.asList(list).toString());
        return list;
    }

    //метод создания рандомного элемента
    public static Integer createNumber() {
        Integer num = new Random().nextInt(20);
        System.out.println(num);
        return num;
    }

    /**
     * метод бинарного поиска
     *
     * @param midpoint - индекс среднего элемента
     * @param min      - индекс минимального элемента
     * @param max      - индекс аксимального элемента
     * @return - индекс искомого элемента или -1 в слуае, если элемент не найден
     */
    //для списка
    public static int binSearch2(List<Integer> list, Integer value, int min, int max) {
        int midpoint;
        if (max < min) {
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }
        if (list.get(midpoint) < value) {
            return binSearch2(list, value, midpoint + 1, max);
        } else {
            if (list.get(midpoint) > value) {
                return binSearch2(list, value, min, midpoint - 1);
            } else {
                return midpoint;
            }
        }
    }

    /* метод создания произвольного массива, допускает создание дубликатов
        public static Integer[] createArray() {
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(20);
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        return array;
    }
         */
    /* метод бинарного поиска для массива
        public static int binSearch(Integer[] array, Integer value, int min, int max) {
        int midpoint;
        if (max < min) {
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }
        if (array[midpoint] < value) {
            return binSearch(array, value, midpoint + 1, max);
        } else {
            if (array[midpoint] > value) {
                return binSearch(array, value, min, midpoint - 1);
            } else {
                return midpoint;
            }
        }
    }
     */
}