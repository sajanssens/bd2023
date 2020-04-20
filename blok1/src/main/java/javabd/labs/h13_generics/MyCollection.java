package javabd.labs.h13_generics;

import static java.util.Arrays.copyOf;

public class MyCollection {
    private Integer[] items = new Integer[4];
    private int length = 0;

    public void add(Integer i) {
        if (length == items.length) {
            expandItems();
        }
        items[length++] = i;
    }

    private void expandItems() {
        // Integer[] newItems = new Integer[items.length * 2];
        // for (int i = 0; i < items.length; i++) {
        //     newItems[i] = items[i];
        // }
        // items = newItems;

        // or
        items = copyOf(items, items.length * 2);
    }

    public Integer get(int i) {
        return items[i];
    }

    public int getLength() {
        return length;
    }
}
