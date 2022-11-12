package ru.job4j.collection;


import java.util.*;

public class SimpleLinkedList<E> implements LinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;
    private int modCount;

    @Override
    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        if (null == first) {
           first = newLink;
            last = newLink;
        } else {
            last.next = newLink;
            last = newLink;
        }
        size++;
        modCount++;
     }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
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

    private class Itr implements Iterator<E> {
        private final int  expectedModCount = modCount;
        Node<E> current = first;

        @Override
        public boolean hasNext() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            return current != null;
        }
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = current.date;
            current = current.next;
            return result;
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