package org.example;

public class CalculateSum implements FuncInterface{
    @Override
    public int sum(int a, int b) {
        int result = a+b+2;
        System.out.printf("sum methode in sum func interface called %s%n", result);
        return result;
    }
}
