package hw;

import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private int freeCell = 9; //счетчик свободных ячеек

    public void mainMenu() {
        while (true) {
            System.out.println("Выберите действие:\n" +
                    "1. Играть\n" +
                    "2. Выйти\n");
            Integer choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                Desk desk = new Desk();
                while (freeCell > 0) {
                    //Ход 1-го игрока: если result = true, то игра заканчивается, если false - продолжается
                    boolean result1 = game(desk, 1, "X");
                    if (result1) {
                        System.out.println("Игра ОКОНЧЕНА! Победил 1-й игрок (X) !!!");
                        desk.printDesk();
                        freeCell=9;
                        break;
                    }
                    freeCell--;
                    //проверка свободных ячеек
                    if (freeCell == 0) {
                        System.out.println("Все ячейки заняты!НИЧЬЯ!!!");
                        freeCell=9;
                        break;
                    }
                    //Ход 2-го игрока: если result = true, то игра заканчивается, если false - продолжается
                    boolean result2 = game(desk, 2, "O");
                    if (result2) {
                        System.out.println("Игра ОКОНЧЕНА! Победил 2-й игрок (O) !!!");
                        desk.printDesk();
                        freeCell=9;
                        break;
                    }
                    freeCell--;

                    System.out.println("Продолжить?\n" +
                            "1.да\n" +
                            "2.нет\n");
                    Integer choiceContinue = scanner.nextInt();
                    scanner.nextLine();
                    if (choiceContinue == 2) {
                        break;
                    }
                }
            }
            if (choice == 2) {
                break;
            }
        }
    }

    // метод ведения игры, где игрок выбирает ячейки, затем проверяется результат хода и передается в основное меню
    public boolean game(Desk gameDesk, int gamer, String element) {
        System.out.println("Выберите номер ячейки, чтобы сделать ход (" + gamer + "-й игрок," + element + "): ");
        gameDesk.printDesk();
        Integer choice = scanner.nextInt();
        scanner.nextLine();
        boolean resultStep = gameDesk.makeMove(choice, element);
        if (!resultStep) {
            System.out.println("Ячейка занята!Выберите другую!!");
            game(gameDesk, gamer, element);
        }
        boolean resultWin = gameDesk.checkWin(element);
        return resultWin;
    }


}
