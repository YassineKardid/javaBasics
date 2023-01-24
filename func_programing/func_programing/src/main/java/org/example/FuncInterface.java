package org.example;

@FunctionalInterface
public interface FuncInterface {
    public int sum(int a, int b);
    default void defaultMethod(){
        System.out.println(" Default method called");
    }
}
