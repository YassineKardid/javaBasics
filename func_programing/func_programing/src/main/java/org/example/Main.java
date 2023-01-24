package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static double sum(ArrayList<? extends Number> numbers) {
        double result = 0.0;
        for (Number num : numbers) result += num.doubleValue();
        return result;
    }

    public static void main(String[] args) {
          /* ############################################ */
          // final class
        FinalClass f1 = new FinalClass();
        f1.method(2);
        ExtendsFinalClass exf1 = new ExtendsFinalClass();
        exf1.method(5);

          /* ############################################ */
          // wild card
//        School<Double, String> teacher = new Teacher<>();
//        teacher.teach(4D, "55");
          //Teacher<? extends Double, ?> teacher2 = new Teacher<>(); //not possible

//        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(2, 4, 6));
//        double sum = sum(integers);
//        System.out.println("Sum of integers = " + sum);
//        WildCard<?> card = new WildCard<>();//not possible
//        String s = "aaa";//not possible
//        card.printTest(s); //not possible
          /* ############################################ */
          //List<String> books = List.of("book1", "book2", "book3", "book3");
        Collection books = new ArrayList<>(Arrays.asList("55", "ab"));
        Iterator<String> booksIter = books.iterator();
        while (booksIter.hasNext())
        {
            String book = booksIter.next();
            System.out.println(book);
        }
        //String[] books = {"45", "ax"};
        //int[] books = {45, 68};
//        for (Object book : books) {
//            System.out.println(book);
//        }
        /* ############################################ */
//        Map<Integer, String> books = new LinkedHashMap<>();
//        books.put(45, "aw");
//        books.put(87, "qw");
//        books.put(86, "ba");
//        //looping through hashmap
//        for (Map.Entry<Integer, String> book : books.entrySet()) {
//            System.out.println(book.getKey());
//            System.out.println(book.getValue());
//        }
//        System.out.println(books);

         /* ############################################ */
//        long count = books.stream().count();
//        List<Book> booksObj = books.stream().filter(b -> b.startsWith("b"))
//                .distinct()
//                .map(b -> new Book(Book.generateId(), b)).collect(Collectors.toList());
//        //.forEach(System.out ::println);
//        for (Book bookObj : booksObj) {
//            System.out.println(bookObj);
//        }
//        System.out.println(count);
            /* ############################################ */
        // call implemented method àin the interface overridden
        Book book1 = new Book(Book.generateId(), "book7");
        book1.readBook();
          /* ############################################ */
        // extends abstract methods
        BiblioInterface table1 = new MeetingTable();
        table1.readBook();
          /* ############################################ */
        // implement functional interface
        FuncInterface calculateSum = new CalculateSum();
        calculateSum.sum(5,2);
         /* ############################################ */
        // implement func interface using lambda
        FuncInterface func = (int a, int b) -> {
            return a + b;
        };

        int result = func.sum(4, 3);
        System.out.printf("Lambda func result %d", result);

    }
}