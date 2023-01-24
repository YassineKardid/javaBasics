package demo.test1;

import java.math.BigDecimal;

public class OuterClass {
    public BigDecimal division(float a, float b) {
        BigDecimal division = null;
        try {
            BigDecimal a1 = new BigDecimal(11);
            BigDecimal a2 = new BigDecimal(17);
            division = a1.divide(a2);
        } catch (ArithmeticException e) //| IllegalAccessError
        {
            System.out.println("Exception caught");
            throw new ArithmeticException("Custom message");
        }
        return division;
    }

    public void sayHi() {
        System.out.println("i'm in the outer class");
    }

    public class InnerClass {
        public int returnInt(int myInt) {
            System.out.println("i'm in the inner class");
            return myInt;
        }
    }

    public static class StaticInnerClass {
        public String sayHi() {
            System.out.println("hello from static Inner class");
            return "hi";
        }

        public static void staticMethod() {
            System.out.println("static methode in the inner static class is invoked");
        }
    }

}
