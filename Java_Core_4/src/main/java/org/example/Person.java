package org.example;

import java.time.LocalDate;

/**
 * Класс, представляющий сущность "Человек".
 */
public class Person {
    private int id;                    // Уникальный идентификатор человека
    private String name;               // Имя человека
    private char gender;               // Пол человека ('M' - мужской, 'F' - женский)
    private Department department;     // Подразделение, к которому принадлежит человек
    private double salary;             // Зарплата человека
    private LocalDate dateOfBirth;     // Дата рождения человека

    /**
     * Конструктор для создания объекта Person с заданными параметрами.
     *
     * @param id           уникальный идентификатор человека
     * @param name         имя человека
     * @param gender       пол человека ('M' - мужской, 'F' - женский)
     * @param department   подразделение, к которому принадлежит человек
     * @param salary       зарплата человека
     * @param dateOfBirth  дата рождения человека
     */
    public Person(int id, String name, char gender, Department department, double salary, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Получить уникальный идентификатор человека.
     *
     * @return уникальный идентификатор человека
     */
    public int getId() {
        return id;
    }

    /**
     * Получить имя человека.
     *
     * @return имя человека
     */
    public String getName() {
        return name;
    }

    /**
     * Получить пол человека.
     *
     * @return пол человека ('M' - мужской, 'F' - женский)
     */
    public char getGender() {
        return gender;
    }

    /**
     * Получить подразделение, к которому принадлежит человек.
     *
     * @return объект подразделения
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Получить зарплату человека.
     *
     * @return зарплата человека
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Получить дату рождения человека.
     *
     * @return дата рождения человека
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Переопределенный метод toString для представления объекта Person в виде строки.
     *
     * @return строковое представление объекта Person
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", department=" + department.getName() +
                ", salary=" + salary +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
