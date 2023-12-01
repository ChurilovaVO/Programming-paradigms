package hw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class HomeWork_1 {
    public static void main(String[] args) {

        //Создаем список
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            numbers.add(new Random().nextInt(100));
        }
        PrintList(numbers, "Список: ");
        sortInDescendingOrder(numbers, 0, numbers.size() - 1);
        PrintList(numbers, "Императивный подход: ");
        sortDeclarative(numbers);
        PrintList(numbers, "Декларативный подход: ");
    }

    //Сортировка по убванию, императивный подход
    public static List<Integer> sortInDescendingOrder(List<Integer> myList, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = myList.get((startPosition + endPosition) / 2);
        do {
            while (myList.get(leftPosition) > pivot) {
                leftPosition++;
            }
            while (myList.get(rightPosition) < pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    Integer temp = myList.get(leftPosition);
                    myList.set(leftPosition, myList.get(rightPosition));
                    myList.set(rightPosition, temp);
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);
        if (leftPosition < endPosition) {
            sortInDescendingOrder(myList, leftPosition, endPosition);
        }
        if (startPosition < rightPosition) {
            sortInDescendingOrder(myList, startPosition, rightPosition);
        }
        return myList;
    }

    //Сортировка по убыванию, декларативный подход
    public static List<Integer> sortDeclarative(List<Integer> myList) {
        myList.sort(Comparator.reverseOrder());
        return myList;
    }

    // Метод вывода списка в консоль
    public static void PrintList(List<Integer> myList, String type){
        System.out.print(type);
        for (Integer num : myList) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
