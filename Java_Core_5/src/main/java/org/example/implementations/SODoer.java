package org.example.implementations;

import org.example.interfaces.SomeOtherInterface;

/**
 * Класс SODoer реализует интерфейс SomeOtherInterface
 */
public class SODoer implements SomeOtherInterface {

    /**
     * Метод doSomeOther выводит на консоль символ "C".
     */
    @Override
    public void doSomeOther() {
        System.out.println("C");
    }
}
