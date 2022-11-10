package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> storage = new HashMap<>();

    @Override
    public void add(T model) {
        if (!this.storage.containsKey(model.getId())) {
            this.storage.put(model.getId(), model);
        }
    }

    @Override
    public boolean replace(String id, T model) {
        return this.storage.put(id, model) != null;
    }

    @Override
    public boolean delete(String id) {
        return storage.remove(id) != null;
    }

    @Override
    public T findById(String id) {
        return storage.get(id);
    }
}
