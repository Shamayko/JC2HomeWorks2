package HomeWork3;

import java.util.*;

public class WordArray {


    /**
     * СОздаем массив активации Зимнего солдата с добавлением повторяющихся слов
     */

    static ArrayList<String> list = new ArrayList<>(Arrays.asList("Желание", "Семнадцать", "Ржавый",
            "Рассвет", "Печь", "Девять", "Добросердечный", "Возвращение на родину",
            "Один", "Товарный вагон", "Ржавый", "Семнадцать", "Девять", "Желание"));

    /**
     * Метод, который считает сколько раз каждое слово встречается в массиве.
     *
     * @param list
     */

    static void wordsCount(ArrayList<String> list) {
        System.out.println("Сколько раз слово встречается в массиве: ");
        int wordCount = 0;
        for (int i = 0; i < WordArray.list.size(); i++) {
            String word = WordArray.list.get(i);
            for (int j = 0; j < WordArray.list.size(); j++) {
                String word2 = WordArray.list.get(j);
                if (word.equals(word2)) {
                    wordCount++;
                }
            }
            System.out.println(word + " " + wordCount);
            wordCount = 0;
        }
    }


    /**
     * Переводим массив в сет, чтобы при выводе убрать повторяющиеся слова.
     */
    static Set set = new LinkedHashSet(list);

    public static void main(String[] args) {

        /**
         * Выводим на печать Сет, что отсеивает повторяющиеся слова в массиве.
         * Запускаем подсчет сколько раз слово встречается в массиве.
         */
        System.out.println(set);
        wordsCount(list);
    }
}
