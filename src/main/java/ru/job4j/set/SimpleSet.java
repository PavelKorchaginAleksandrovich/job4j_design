package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        boolean hasDuplicate = contains(value);
         if (!hasDuplicate) {
            set.add(value);
        }
        return !hasDuplicate;
    }

    @Override
    public boolean contains(T value) {
        boolean hasDuplicate = false;
        for (int i = 0; i < set.size(); i++) {
            //if (set.get(i).equals(value)) {
            if (Objects.equals(set.get(i), value)) {
                    hasDuplicate = true;
                    break;
            }
        }
        return hasDuplicate;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}