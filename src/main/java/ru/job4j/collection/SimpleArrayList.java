package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {
    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (this.size < this.container.length) {
            this.container[size++] = value;
        } else {
            this.container = Arrays.copyOf(this.container, this.container.length * 2);
            this.container[size++] = value;
        }
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        this.container[index] = newValue;
        if (index >= size) {
            size++;
        }
        return newValue;
    }

    @Override
    public T remove(int index) {
        T result = this.container[index];
        System.arraycopy(this.container, index + 1, this.container, index, this.size - index - 1);
        this.container[--size] = null;
        return result;
    }

    @Override
    public T get(int index) {
        return this.container[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor = 0;
            int expectedModCount  = modCount;
            @Override
            public boolean hasNext() {
                return cursor != container.length;
            }

            @Override
            public T next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (cursor >= container.length) {
                    throw new NoSuchElementException();
                }
                return (T) container[cursor++];

            }

        };
    }
}
