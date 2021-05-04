package HomeWork2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException{

    public MyArraySizeException() {
        super("Неверный размер массива!");
    }
}