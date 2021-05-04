package HomeWork2;

public class ArrayMethod {
    /**
     * создаем переменные, которые определяют целевой размер массива
     */
    private static int arrayFirstSize = 4;
    private static int arraySecondSize = 4;

    /**
     * Пишем общий метод, который обращается к методу проверки размера массива
     * и методу приведения содержимого к int с последующим суммированием.
     * Также метод выводит сумму массива на экран, если подан корректный массив.
     * @param array
     * @throws MyArraySizeException
     * @throws MyArrayDataException
     */
    public static void someArrayMethod(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (!isSizeOfArrayValid(array)) {
            throw new MyArraySizeException();
        }
        toIntegerTransformAndSum(array);

        System.out.println("Сумма элементов массива равна: " + toIntegerTransformAndSum(array));

    }

    /**
     * Метод, который определяет соответствие массива заданным параметрам.
     * @param array
     * @return
     */

    private static boolean isSizeOfArrayValid(String[][] array) {
        if (array.length == arrayFirstSize) {
            for (int i = 0; i < array.length; i++) {
                if (array[i].length != arraySecondSize) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Метод, который парсит к int и возвращает сумму массива.
     * Также определяет в какой ячейке массива закралось исключение и выводит информацию об этом.
     * @param array
     * @return
     * @throws MyArrayDataException
     */
    private static int toIntegerTransformAndSum(String[][] array) throws MyArrayDataException {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException ("Ошибка!!! В ячейке [" + i + "] " + "[" + j + "]" +
                            " содержится " + array[i][j]);


                }
            }
        }

        return sum;
    }

}
