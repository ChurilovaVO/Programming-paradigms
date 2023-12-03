package hw;

//класс Ячейки доски
public class Cell {
    private String element; //элемент ячейки "о/х"
    private int cellNumber; //порядковый номер ячейки

    public Cell(int cellNumber){
        this.cellNumber=cellNumber;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }

    public int getCellNumber() {
        return cellNumber;
    }

  }
