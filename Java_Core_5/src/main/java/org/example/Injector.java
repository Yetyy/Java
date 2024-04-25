package org.example;

import org.example.annotations.AutoInjectable;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Класс Injector отвечает за внедрение зависимостей в объекты,
 * помеченные аннотацией @AutoInjectable.
 *
 * @see AutoInjectable
 */
public class Injector {

    /**
     * Свойство properties содержит конфигурацию внедрения зависимостей.
     */
    private Properties properties;

    /**
     * Конструктор по умолчанию инициализирует свойство properties.
     */
    public Injector() {
        properties = new Properties();
        try (InputStream input = Injector.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод inject внедряет зависимости в объект object.
     *
     * @param <T> тип объекта, в который внедряются зависимости
     * @param object объект, в который внедряются зависимости
     * @return объект с внедренными зависимостями
     * @throws ReflectiveOperationException в случае ошибки при внедрении зависимостей
     */
    public <T> T inject(T object) throws ReflectiveOperationException {
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                String className = properties.getProperty(field.getType().getName());
                Class<?> clazz = Class.forName(className);
                Object instance = clazz.getDeclaredConstructor().newInstance();
                field.setAccessible(true);
                field.set(object, instance);
            }
        }
        return object;
    }
}
