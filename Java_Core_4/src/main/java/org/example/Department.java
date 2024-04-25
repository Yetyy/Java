package org.example;

/**
 * Класс, представляющий сущность "Подразделение".
 */
public class Department {
    private static int nextId = 1;  // Статическое поле для генерации уникальных идентификаторов подразделений

    private int id;                 // Уникальный идентификатор подразделения
    private String name;            // Название подразделения

    /**
     * Конструктор для создания объекта Department с заданным названием.
     *
     * @param name название подразделения
     */
    public Department(String name) {
        this.id = generateId();     // Генерируем уникальный идентификатор при создании нового подразделения
        this.name = name;
    }

    /**
     * Статический синхронизированный метод для генерации уникального идентификатора подразделения.
     *
     * @return уникальный идентификатор подразделения
     */
    private static synchronized int generateId() {
        return nextId++;            // Увеличиваем счетчик и возвращаем новый уникальный идентификатор
    }

    /**
     * Получить уникальный идентификатор подразделения.
     *
     * @return уникальный идентификатор подразделения
     */
    public int getId() {
        return id;
    }

    /**
     * Получить название подразделения.
     *
     * @return название подразделения
     */
    public String getName() {
        return name;
    }

    /**
     * Переопределенный метод toString для представления объекта Department в виде строки.
     *
     * @return строковое представление объекта Department
     */
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
