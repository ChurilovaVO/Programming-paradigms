package hw;

import java.util.Scanner;

//Объяснение в файле README

public class HomeWork__2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer num = scanner.nextInt();
        scanner.close();
        printMultiTable(num);
    }


    //метод вывода в консоль таблицы умножения
    public static void printMultiTable(Integer n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.println(i + "*" + j + "=" + (i * j));
            }
            System.out.println();
        }
    }
}