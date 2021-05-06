package HomeWork5;

public class ThreadApp {
    static final int ARRAY_SIZE = 10000000;
    static final int HALF_SIZE = (ARRAY_SIZE / 2);

    public static void main(String[] args) throws InterruptedException {
        taskMethod1();
        taskMethod2();
    }

    public static void taskMethod1() {
        long a = System.currentTimeMillis();

        float[] array1 = new float[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array1[i] = 1;
        }
        long b = System.currentTimeMillis();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array1[i] = (float) (array1[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long c = (System.currentTimeMillis() - b);
        System.out.println("На цикл расчета для Массива 1 ушло " + c + " миллисекунд.");


        System.out.println("Всего на работу Метода1 ушло " + (System.currentTimeMillis() - a) + " миллисекунд.");
    }

    public static void taskMethod2() throws InterruptedException {
        long a = System.currentTimeMillis();
        float[] array2 = new float[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array2[i] = 1;
        }
        long b = System.currentTimeMillis();

        /**
         * Делим массив на 2 части
         */

        float[] array2p1 = new float[HALF_SIZE];
        float[] array2p2 = new float[HALF_SIZE];

        Thread thread1 = new Thread(() -> System.arraycopy(array2, 0, array2p1, 0, HALF_SIZE));

        Thread thread2 = new Thread(() -> System.arraycopy(array2, HALF_SIZE, array2p2, 0, HALF_SIZE));
        thread1.start();
        thread2.start();

        long c = (System.currentTimeMillis() - b);
        System.out.println("Разделение массива на 2 части в 2 потока заняло " + c + " миллисекунд.");

        /**
         * Перезаполняем массив в 2 потока.
         */

        long d = System.currentTimeMillis();

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < array2p1.length; i++) {
                array2p1[i] = (float) (array2p1[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < array2p2.length; i++) {
                array2p2[i] = (float) (array2p2[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        thread3.start();
        thread4.start();
        thread3.join();
        thread4.join();
        long e = (System.currentTimeMillis() - d);
        System.out.println("На перезаполнение массива в 2 потока ушло " + e + " миллисекунд.");

        /**
         * Склеиваем массив обратно.
         */
        long f = System.currentTimeMillis();

        Thread thread5 = new Thread(() -> System.arraycopy(array2p1, 0, array2, 0, HALF_SIZE));

        Thread thread6 = new Thread(() -> System.arraycopy(array2p2, 0, array2, HALF_SIZE, HALF_SIZE));

        thread5.start();
        thread6.start();
        thread5.join();
        thread6.join();

        long j = (System.currentTimeMillis()- f);
        System.out.println("На склейку Массива 2 ушло " + j + " милисекунд.");
        System.out.println("Всего на работу метода 2 ушло "+ (System.currentTimeMillis() - a) + " миллисекунд.");

    }
}
