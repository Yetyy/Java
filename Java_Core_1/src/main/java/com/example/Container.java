package com.example;

import java.util.Arrays;

/**
 * Класс, представляющий контейнер для хранения целочисленных элементов.
 */
public class Container {

    /** Массив элементов контейнера */
    private int[] elements;

    /** Текущий размер контейнера */
    private int size;

    /** Стандартная начальная ёмкость контейнера */
    protected static final int DEFAULT_CAPACITY = 10;

    /**
     * Создает новый контейнер с начальной ёмкостью по умолчанию.
     */
    public Container() {
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Добавляет элемент в контейнер.
     *
     * @param element Элемент для добавления
     */
    public void add(int element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size++] = element;
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index Индекс элемента для возврата
     * @return Элемент по указанному индексу
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы допустимого диапазона
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return elements[index];
    }

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index Индекс элемента для удаления
     * @return Удаленный элемент
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы допустимого диапазона
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        int removedElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return removedElement;
    }

    /**
     * Возвращает текущий размер контейнера.
     *
     * @return Текущий размер контейнера
     */
    public int size() {
        return size;
    }
}
