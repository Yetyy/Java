package org.example.annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация AutoInjectable используется для автоматического внедрения зависимостей.
 *
 * @see Injector
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoInjectable {}
