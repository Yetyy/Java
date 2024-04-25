package org.example.implementations;

import org.example.interfaces.SomeInterface;

/**
 * Класс OtherImpl реализует интерфейс SomeInterface.
 *
 * @see SomeInterface
 */
public class OtherImpl implements SomeInterface {

    /**
     * Метод doSomething выводит на консоль символ "B".
     */
    @Override
    public void doSomething() {
        System.out.println("B");
    }
}
