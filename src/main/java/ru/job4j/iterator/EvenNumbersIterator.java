package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }
    @Override
    public boolean hasNext() {
        movePointerToEvenNumber();
        return index < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }
    private void movePointerToEvenNumber() {
        while (index < data.length && data[index] % 2 > 0) {
            index++;
        }
    }
}