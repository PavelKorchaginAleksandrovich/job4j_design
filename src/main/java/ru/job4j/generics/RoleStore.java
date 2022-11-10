package ru.job4j.generics;

public class RoleStore implements Store<Role> {

    private final Store<Role> role = new MemStore<>();

    @Override
    public void add(Role role) {
        this.role.add(role);
    }

    @Override
    public boolean replace(String id, Role role) {
        return this.role.replace(id, role);
    }

    @Override
    public boolean delete(String id) {
        return this.role.delete(id);
    }

    @Override
    public Role findById(String id) {
        return this.role.findById(id);
    }
}
