package org.example;


public class Book implements BiblioInterface {
    private int id;
    private String title;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public void readBook() {
        System.out.println("i'm the overridden method readBook");
    }

    public static Integer generateId() {
        int a = (int) (Math.random() * (20 - 10 + 1) + 10);
        return a;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
