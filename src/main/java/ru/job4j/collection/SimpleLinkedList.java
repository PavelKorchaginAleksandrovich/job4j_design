package ru.job4j.collection;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements LinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;
    private int modCount;

    @Override
    public void add(E value) {
        Node<E> newLink = new Node<>(value);

        if (null == this.first) {
           this.first = newLink;
        } else {
            this.last.next = newLink;
        }
        this.last = newLink;
        this.size++;
        this.modCount++;
     }

    @Override
    public E get(int index) {
        checkIndex(index);
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private class Itr implements Iterator<E> {
        private int expectedModCount = modCount;
        Node<E> current = first;
        int cursor;

        @Override
        public boolean hasNext() {
            return this.cursor < size;
        }

        @Override
        public E next() {
            checkForModification();
            if (hasNext()) {
                E result;
                result = current.date;
                this.current = this.current.next;
                this.cursor++;
                return result;
            } else {
                throw new NoSuchElementException();
            }
        }
        final void checkForModification() throws ConcurrentModificationException {
            if (modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
    private static class Node<E> {
        E date;
        Node<E> next;
        Node(E date) {
            this.date = date;
        }
    }
}