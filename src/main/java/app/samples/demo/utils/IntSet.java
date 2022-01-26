package app.samples.demo.utils;

import java.util.Arrays;

class IntSet {
    private int [] items;
    private int size;

    public IntSet() {
        this(100);
    }

    public IntSet(int initialCapacity) {
        size = 0;
        items = new int[initialCapacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int i) {
        if(!contains(i)) {
            if(size >= items.length) {
                items = Arrays.copyOf(items, items.length * 2);
            }
            items[size++] = i;
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(int i) {
        return indexOf(i) >= 0;
    }

    public void remove(int i) {
        int index = indexOf(i);
        if(index >=0 ) {
            items[index] = items[size--];
        }
    }

    private int indexOf(int i) {
        for(int index = size - 1; index >= 0; index--) {
            if(items[index] == i) {
                return index;
            }
        }
        return -1;
    }
}
