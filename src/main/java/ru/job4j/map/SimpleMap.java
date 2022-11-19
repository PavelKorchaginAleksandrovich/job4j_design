package ru.job4j.map;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean result = false;
        int keyHashCode = Objects.hashCode(key);
        int index = indexFor(hash(keyHashCode));
        if (table[index] == null) {
            MapEntry element = new MapEntry(key, value);
            table[index] = element;
            result = true;
            count++;
            modCount++;
        }
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        return result;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash % capacity;
    }

    private void expand() {
        capacity *= 2;
        MapEntry[] newContainer = new MapEntry[capacity];
        for (MapEntry elem : table) {
            if (elem != null) {
                newContainer[indexFor(hash(Objects.hashCode(elem.key)))] = elem;
            }
        }
        table = newContainer;
    }

    @Override
    public V get(K key) {
        int keyHashCode = Objects.hashCode(key);
        MapEntry element = table[indexFor(hash(keyHashCode))];
        return element == null ? null : (keyHashCode == Objects.hashCode(element.key) && Objects.equals(key, element.key) ? (V) element.value : null);
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int keyHashCode = Objects.hashCode(key);
        int index = indexFor(hash(keyHashCode));
        MapEntry element = table[index];
        if (element != null && keyHashCode == Objects.hashCode(element.key) && Objects.equals(key, element.key)) {
            table[index] = null;
            count--;
            modCount++;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Itr<>();
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
    private class Itr<K> implements Iterator<K> {

        final int expectedModCount  = modCount;
        private int cursor = 0;
        private int counter = 0;


        @Override
        public boolean hasNext() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            return counter < count;
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            MapEntry element = table[cursor++];
            if (element != null) {
                counter++;
            }
            return element != null ? (K) element.key : next();
        }
    }

}