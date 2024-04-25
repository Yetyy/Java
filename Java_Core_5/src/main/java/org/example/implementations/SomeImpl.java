package org.example.implementations;


import org.example.interfaces.SomeInterface;

/**
 * Класс SomeImpl реализует интерфейс SomeInterface.
 */
public class SomeImpl implements SomeInterface {

    /**
     * Метод doSomething выводит на консоль символ "A".
     */
    @Override
    public void doSomething() {
        System.out.println("A");
    }
}
