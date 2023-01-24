package demo.test1;

import org.example.FuncInterface;
import org.example.School;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        //anonymous class
        /* ################# */
        School<Integer, String > school = new School<Integer, String>() {
            @Override
            public void teach(Integer a, String b) {
                System.out.println("Anonymous class  interface");
            }
        };
        school.teach(1, "test");

        OuterClass outerClass= new OuterClass(){
            public BigDecimal division(float a, float b){
                System.out.println("Anonymous class class");
                BigDecimal a1 = new BigDecimal(110);
                BigDecimal a2 = new BigDecimal(17);
                return a1.divide(a2, RoundingMode.HALF_UP);

            }
        };
        outerClass.division(1.0f, 4);
        /* ################# */
        Scanner in = new Scanner(System.in);
        //int inValue = in.nextInt();
        //System.out.println(inValue);

        /* ################# */
        OuterClass out = new OuterClass();
        out.sayHi();
        OuterClass.InnerClass innerClass = out.new InnerClass();
        innerClass.returnInt(77);

        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
        staticInnerClass.sayHi();
        // staticInnerClass.staticMethod(); // it works too
        OuterClass.StaticInnerClass.staticMethod();
        /* ################# */
        FuncInterface funcImplem = (int a, int b) ->
        {
            System.out.println("i'm in the lambda functional interface");
            return a + b * 2;
        };
        int result = funcImplem.sum(4, 2);
        System.out.println("Result of the functional interface " + result);
        /* ################# */

        List<String> rooms1 = new ArrayList<>(Arrays.asList("r1", "r2", "r3", "r4"));
        List<String> rooms2 = new LinkedList<>(Arrays.asList("r1", "r2", "r3", "r4"));
        Vector<String> rooms3 = new Vector<>(Arrays.asList("r1", "r2", "r3", "r4"));
        rooms3.add("r5");
        for (String room : rooms1) {
            System.out.println(room);
        }
        Iterator<String> strItr = rooms2.iterator();

        while(strItr.hasNext())
        {
            String str = strItr.next();
            System.out.println("Iterator: " +str);
        }
        Map<Integer, String> dict1 = new LinkedHashMap<>();
        Map<Integer, String> dict2 = new TreeMap<>();
        Map<Integer, String> dict = new HashMap<>();
        dict.put(3, "Yassine");
        dict.put(1, "Ali");
        dict.put(2, "Zahra");

        for (Map.Entry<Integer, String> element : dict.entrySet()) {
            System.out.println("key :" + element.getKey() + " value: " + element.getValue());
        }

        Set<String> data = new TreeSet<>();
        data.add("55");
        data.add("elm3");
        data.add(("elm2"));
        for (String dt : data) {
            System.out.println(dt);
        }

        List<String> resultFilter =rooms3.stream().distinct().filter(el -> !el.equals("e")).collect(Collectors.toList());
        System.out.println(resultFilter);
    }
}
