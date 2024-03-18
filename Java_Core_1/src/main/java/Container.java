package main.java;

import java.util.Arrays;

public class Container {
    private int[] elements;
    private int size;
    protected static final int DEFAULT_CAPACITY = 10;

    public Container() {
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(int element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size++] = element;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return elements[index];
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        int removedElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return removedElement;
    }

    public int size() {
        return size;
    }
}
