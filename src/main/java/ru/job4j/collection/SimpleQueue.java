package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private boolean lastOperationIsPush = true;
    private int size;

    public T poll() {
        if (lastOperationIsPush) {
            convert(in, out);
            lastOperationIsPush = false;
        }
        T result = out.pop();
        size--;
        return result;
    }

    public void push(T value) {
        if (!lastOperationIsPush) {
            convert(out, in);
            lastOperationIsPush = true;
        }
        in.push(value);
        size++;
    }

    private void convert(SimpleStack<T> giver, SimpleStack<T> receiver) {
       for (int i = 0; i < size; i++) {
           receiver.push(giver.pop());
           }
    }
}
