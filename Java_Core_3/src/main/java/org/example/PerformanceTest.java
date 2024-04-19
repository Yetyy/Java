package org.example;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс, содержащий тесты производительности операций add, delete и get для ArrayList и LinkedList.
 */
public class PerformanceTest {

    /**
     * Главный метод, запускающий тестирование производительности операций add, delete и get для ArrayList и LinkedList.
     *
     * @param args аргументы командной строки (не используются)
     * @throws NullPointerException если список не инициализирован (это не должно происходить в данном коде)
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка (это не должно происходить в данном коде)
     */
    public static void main(String[] args) {
        // размер списка
        int size = 100000;
        // количество повторений каждой операции
        int loops = 1000;

        // создаем списки
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // заполняем списки значениями
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // тестируем операцию add
        long start = System.nanoTime();
        for (int i = 0; i < loops; i++) {
            arrayList.add(size, size + i);
        }
        long timeArrayListAdd = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < loops; i++) {
            linkedList.add(size, size + i);
        }
        long timeLinkedListAdd = System.nanoTime() - start;

        // тестируем операцию delete
        start = System.nanoTime();
        for (int i = 0; i < loops; i++) {
            arrayList.remove(size - 1);
        }
        long timeArrayListDelete = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < loops; i++) {
            linkedList.remove(size - 1);
        }
        long timeLinkedListDelete = System.nanoTime() - start;

        // тестируем операцию get
        start = System.nanoTime();
        for (int i = 0; i < loops; i++) {
            arrayList.get(size / 2);
        }
        long timeArrayListGet = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < loops; i++) {
            linkedList.get(size / 2);
        }
        long timeLinkedListGet = System.nanoTime() - start;

        // выводим результаты
        System.out.printf("%-10s  %-12s  %-12s  %-12s  %-12s%n", "Операция", "Количество повторений", "Время ArrayList (нс)", "Время LinkedList (нс)", "Разница (нс)");
        System.out.printf("%-10s  %-12d \t\t   %-12d \t\t %-12d  \t\t\t%-12d%n", "add", loops, timeArrayListAdd, timeLinkedListAdd, timeLinkedListAdd - timeArrayListAdd);
        System.out.printf("%-10s  %-12d \t\t   %-12d \t\t %-12d  \t\t\t%-12d%n", "delete", loops, timeArrayListDelete, timeLinkedListDelete, timeLinkedListDelete - timeArrayListDelete);
        System.out.printf("%-10s  %-12d \t\t   %-12d \t\t %-12d  \t\t\t%-12d%n", "get", loops, timeArrayListGet, timeLinkedListGet, timeLinkedListGet - timeArrayListGet);


    }
}
