package hw;

import java.util.ArrayList;
import java.util.List;

public class Desk {
private Cell[] desk; //массив ячеек

    private final int countCell = 9; // количество ячеек

    public Desk() {
        this.desk = new Cell[countCell];
        for (int i = 1; i <= countCell; i++) {
            this.desk[i-1]=new Cell(i);
        }
    }

    //вывод доски в консоль
    public void printDesk() {
        for (int i = 0; i < countCell; i++) {
            if (this.desk[i].getCellNumber() == 4 ||
                    this.desk[i].getCellNumber() == 7) {
                System.out.println();
            }
            if (this.desk[i].getElement() != null) {
                System.out.print(this.desk[i].getElement() + " ");
            } else {
                System.out.print(this.desk[i].getCellNumber() + " ");
            }
        }
        System.out.println();
    }

    //сделать ход
    public boolean makeMove(int numCell, String element) {
        if (this.desk[numCell - 1].getElement() == null) {
            this.desk[numCell - 1].setElement(element);
            return true;
        } else {
            return false;
        }
    }

    //проверка выигрыша
    public boolean checkWin(String element) {
        if (this.desk[0].getElement() == element && this.desk[1].getElement() == element &&
                this.desk[2].getElement() == element ||
                this.desk[3].getElement() == element && this.desk[4].getElement() == element &&
                        this.desk[5].getElement() == element ||
                this.desk[6].getElement() == element && this.desk[7].getElement() == element &&
                        this.desk[8].getElement() == element ||
                this.desk[0].getElement() == element && this.desk[3].getElement() == element &&
                        this.desk[6].getElement() == element ||
                this.desk[1].getElement() == element && this.desk[4].getElement() == element &&
                        this.desk[7].getElement() == element ||
                this.desk[2].getElement() == element && this.desk[5].getElement() == element &&
                        this.desk[8].getElement() == element ||
                this.desk[0].getElement() == element && this.desk[4].getElement() == element &&
                        this.desk[8].getElement() == element ||
                this.desk[2].getElement() == element && this.desk[4].getElement() == element &&
                        this.desk[6].getElement() == element) {
            return true;
        }
        return false;
    }
}





