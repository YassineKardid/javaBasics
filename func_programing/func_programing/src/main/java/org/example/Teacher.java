package org.example;

public class Teacher<T extends Double, D> implements School<T , D>{
    @Override
    public void teach(T a, D b) {
        System.out.println("Generics method test called");
    }
}
