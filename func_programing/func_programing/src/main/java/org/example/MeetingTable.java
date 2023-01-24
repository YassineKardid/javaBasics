package org.example;

// extends abstract methods
public class MeetingTable extends Table{
    @Override
    public void readBook() {
        System.out.println("Called from abstract class");
    }
}
