package org.example;

import org.example.annotations.AutoInjectable;
import org.example.interfaces.SomeInterface;
import org.example.interfaces.SomeOtherInterface;

/**
 * Класс SomeBean представляет собой бин, содержащий две зависимости,
 * помеченные аннотацией @AutoInjectable.
 *
 * @see AutoInjectable
 * @see SomeInterface
 * @see SomeOtherInterface
 */
public class SomeBean {

    /**
     * Первая зависимость, реализующая интерфейс SomeInterface.
     */
    @AutoInjectable
    private SomeInterface field1;

    /**
     * Вторая зависимость, реализующая интерфейс SomeOtherInterface.
     */
    @AutoInjectable
    private SomeOtherInterface field2;

    /**
     * Метод foo вызывает методы doSomething() и doSomeOther() для первой и второй зависимостей соответственно.
     */
    public void foo() {
        field1.doSomething();
        field2.doSomeOther();
    }
}
