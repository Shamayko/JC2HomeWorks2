package HomeWork3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook2 {
    private Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    /**
     * Метод add() который добавляет имя и номер телефона в виде листа.
     * Если такое имя уже встречалось, новый номер просто складывается в уже имеющийся лист.
     *
     * @param name
     * @param phoneNumber
     */
    public void add(String name, Integer phoneNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNumber);
        } else phoneBook.put(name, new ArrayList<>(Arrays.asList(phoneNumber)));
    }

    /**
     * Метод get(), который выводит нам запрошенное имя + номера,
     * содержащиеся в хэшмапе по данному имени.
     *
     * @param name
     */
    public void get(String name) {
        System.out.println(name + " " + phoneBook.get(name));
    }

    public static void main(String[] args) {
        PhoneBook2 phoneBook = new PhoneBook2();
        phoneBook.add("Petya", 987111111);
        phoneBook.add("Kolya", 987333333);
        phoneBook.add("Petya", 987222222);

        phoneBook.get("Petya");

    }

}

