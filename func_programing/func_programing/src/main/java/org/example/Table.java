package org.example;

abstract public class Table implements BiblioInterface {
    private int id;

    @Override
    abstract public void readBook();
}
