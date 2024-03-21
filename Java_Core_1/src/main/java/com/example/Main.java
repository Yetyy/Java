package com.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        int num, ind;
        int mode;
        while (flag) {
            System.out.println("1) добавить элемент\n2) удалить элемент\n3) получить значение элемента\n4) получить размер контейнера\n0) выход");
            mode = in.nextInt();
            switch (mode) {
                case 1:
                    System.out.println("Введите число для добавления:");
                    num = in.nextInt();
                    container.add(num);
                    System.out.println("Элемент успешно добавлен.");
                    break;
                case 2:
                    System.out.println("Введите индекс элемента для удаления:");
                    ind = in.nextInt();
                    int removedElement = container.remove(ind);
                    System.out.println("Удаленный элемент: " + removedElement);
                    break;
                case 3:
                    System.out.println("Введите индекс элемента для получения его значения:");
                    ind = in.nextInt();
                    int element = container.get(ind);
                    System.out.println("Значение элемента по указанному индексу: " + element);
                    break;
                case 4:
                    System.out.println("Текущий размер контейнера: " + container.size());
                    break;
                case 0:
                    System.out.println("Выход из программы");
                    flag = false;
                    break;
                default:
                    System.out.println("Введено неверное значение");
            }
        }
    }
}
