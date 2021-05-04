package HomeWork2;

public class HomeWor2App {

    public static void main(String[] args) {

        /**
         * Создаем массив.
         */

        String[][] array = new String[][]{{"1", "2", "3", "4"},
                {"1", "2", "3", "GOD DAMN EXCEPTION))"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        /**
         * Ловим ошибки.
         */

        try {
            ArrayMethod.someArrayMethod(array);

        } catch (MyArraySizeException e) {
            e.printStackTrace();

        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }


    }
}
