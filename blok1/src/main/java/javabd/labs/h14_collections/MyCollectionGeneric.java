package javabd.labs.h14_collections;

import java.util.*;

public class MyCollectionGeneric<T> implements Collection<T> {
    private T[] items = (T[]) new Object[4];
    private int length = 0;

    public boolean add(T i) {
        if (length == items.length) {
            expandItems();
        }
        items[length++] = i;

        return true;
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

    // ------- FROM COLLECTION ---------

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(o)) {
                items[i] = null;
                shift(i);
                return true;
            }
        }
        return false;
    }

    private void shift(int i) {
        for (int j = i + 1; j < items.length; j++) {
            items[j - 1] = items[j];
        }
        length--;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T o : c) {
            this.add(o);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            this.remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        List<T> toBeRemoved = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            T item = items[i];
            if (!c.contains(item)) toBeRemoved.add(item);
        }

        removeAll(toBeRemoved);

        return true;
    }

    @Override
    public void clear() {
        this.items = (T[]) new Object[4];
        this.length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean contains(Object o) {
        while (this.iterator().hasNext()) {
            T t = this.iterator().next();
            if (t.equals(o)) return true;
        }

        // for (T t : this) {
        //     if (t.equals(o)) return true;
        // }

        // for (int i = 0; i < length; i++) {
        //     if (items[i].equals(o)) {
        //         return true;
        //     }
        // }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < items.length && items[index] != null;
            }

            @Override
            public T next() {
                return items[index++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return items;
    }

    @Override
    public <R> R[] toArray(R[] a) {
        return (R[]) Arrays.copyOf(items, length, a.getClass());
    }
}
