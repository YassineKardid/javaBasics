package demo.test1;

import org.example.FuncInterface;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testShouldReturnRightValue()
    {
        FuncInterface funcImplem = (int a, int b) ->
        {
            return a+b*2;
        };
        int result = funcImplem.sum(4, 2);
        assertEquals(8,result);
    }
    @Test
    void testShouldRaiseException()
    {
        OuterClass outClass = new OuterClass();

        //assertEquals(6, result);
//        assertThrows(ArithmeticException.class, () -> {
//            BigDecimal result = outClass.division(12, 0);
//        });
        assertThrows(ArithmeticException.class, () -> {
            int a=5, b =0;
            int result = a/b;
        });
    }
}