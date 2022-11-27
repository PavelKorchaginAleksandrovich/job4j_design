package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.url")).isEqualTo("jdbc:postgresql://127.0.0.1:5432/trackstudio");
    }
    @Test
    void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username")).isEqualTo("postgres");
    }
    @Test
    void whenPairhas() {
        String path = "./data/pair_with_empty_line.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username")).isEqualTo("postgres");
    }
    @Test
    void whenPairHasNotKey() {
        String path = "./data/pair_withtout_key.properties";
        Config config = new Config(path);
        assertThatThrownBy(() -> config.load()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenPairHasNotValue() {
        String path = "./data/pair_withtout_value.properties";
        Config config = new Config(path);
        assertThatThrownBy(() -> config.load()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenPairHasNotKeyAndValue() {
        String path = "./data/pair_withtout_key_and_value.properties";
        Config config = new Config(path);
        assertThatThrownBy(() -> config.load()).isInstanceOf(IllegalArgumentException.class);
    }
}