package com.example;

import static org.junit.Assert.assertEquals;

import com.example.Container;
import org.junit.Test;

public class ContainerTest {

    @Test
    public void testAddAndGet() {
        Container container = new Container();
        container.add(5);
        container.add(10);
        container.add(15);

        assertEquals(5, container.get(0));
        assertEquals(10, container.get(1));
        assertEquals(15, container.get(2));
    }
    @Test
    public void testAddAndSize() {
        Container container = new Container();
        assertEquals(0, container.size());
        container.add(5);
        container.add(10);
        assertEquals(2, container.size());
    }

    @Test
    public void testRemove() {
        Container container = new Container();
        container.add(5);
        container.add(10);
        container.add(15);

        assertEquals(10, container.remove(1));
        assertEquals(5, container.get(0));
        assertEquals(15, container.get(1));
        assertEquals(2, container.size());
    }
    @Test
    public void testRemoveAll() {
        Container container = new Container();
        container.add(5);
        container.add(10);
        container.add(15);
        container.remove(0);
        container.remove(0);
        container.remove(0);
        assertEquals(0, container.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        Container container = new Container();
        container.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBounds() {
        Container container = new Container();
        container.remove(0);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBoundsWhenEmpty() {
        Container container = new Container();
        container.remove(0);
    }


}
