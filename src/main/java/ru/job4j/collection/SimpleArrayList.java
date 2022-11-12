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
        if (this.size >= this.container.length) {
            this.container = Arrays.copyOf(this.container, this.container.length * 2);
        }
        this.container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        checkIndex(index);
        T prev = this.container[index];
        this.container[index] = newValue;
        return prev;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T removed = this.container[index];
        System.arraycopy(this.container, index + 1, this.container, index, this.size - index - 1);
        this.container[--size] = null;
        modCount++;
        return removed;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
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
            final int expectedModCount  = modCount;
            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (cursor >= size) {
                    throw new NoSuchElementException();
                }
                return (T) container[cursor++];

            }

        };
    }
    private void checkIndex(int index) {
      if (index < 0 || index >= size) {
          throw new IndexOutOfBoundsException();
      }
    }
}
