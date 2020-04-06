package javabd.labs.h13_generics;

public class MyCollectionGeneric<T> {
    private T[] items = (T[]) new Object[4];
    private int length = 0;

    public void add(T i) {
        if (length == items.length) {
            expandItems();
        }
        items[length++] = i;
    }

    private void expandItems() {
        T[] newItems = (T[]) new Object[items.length * 2];
        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    public T get(int i) {
        return items[i];
    }

    public int getLength() {
        return length;
    }
}
