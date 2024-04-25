package org.example;

public class Main {
    public static void main(String[] args) {
        Injector injector = new Injector();
        SomeBean someBean;
        try {
            someBean = injector.inject(new SomeBean());
            someBean.foo();
        } catch (ReflectiveOperationException e) {
            System.err.println("Failed to inject dependencies: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
