package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenUsernameIsPavel() {
        RoleStore role = new RoleStore();
        role.add(new Role("2", "Pavel"));
        Role result = role.findById("2");
        assertThat(result.getRoleName()).isEqualTo("Pavel");
    }

    @Test
    void whenAddAndFindThenUserIsNull() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Pavel"));
        Role result = role.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindUsernameIsPavel() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Pavel"));
        role.add(new Role("1", "Maxim"));
        Role result = role.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Pavel");
    }

    @Test
    void whenReplaceThenUsernameIsMaxim() {
        RoleStore role = new RoleStore();
        role.add(new Role("11", "Pavel"));
        role.replace("11", new Role("11", "Maxim"));
        Role result = role.findById("11");
        assertThat(result.getRoleName()).isEqualTo("Maxim");
    }

    @Test
    void whenNoReplaceUserThenNoChangeUsername() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Pavel"));
        role.replace("10", new Role("10", "Maxim"));
        Role result = role.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Pavel");
    }

    @Test
    void whenDeleteUserThenUserIsNull() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Pavel"));
        role.delete("1");
        Role result = role.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteUserThenUsernameIsPAvel() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Pavel"));
        role.delete("10");
        Role result = role.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Pavel");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Pavel"));
        boolean rsl = role.replace("1", new Role("1", "Maxim"));
        assertThat(rsl).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Pavel"));
        boolean rsl = role.replace("10", new Role("10", "Maxim"));
        assertThat(rsl).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Pavel"));
        boolean rsl = role.delete("1");
        assertThat(rsl).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Pavel"));
        boolean rsl = role.delete("2");
        assertThat(rsl).isFalse();
    }

}