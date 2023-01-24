package org.example;

public class WildCard<E> {
    public void printTest(E e) {
        System.out.println(e.getClass());
        System.out.println("Wild card called");
    }
}
