package ru.job4j.assertj;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(2, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void whenVertexIsFourThenShouldBeFour() {
        Box box = new Box(4, 10);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(4);
    }

    @Test
    void whenVertexIsThreeThenShouldBeMinusOne() {
        Box box = new Box(3, 10);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(-1);
    }

    @Test
    void whenVertexIsEightThenShouldBeTrue() {
        Box box = new Box(8, 10);
        boolean exist = box.isExist();
        assertThat(exist).isTrue();
    }

    @Test
    void whenVertexIsFiveThenShouldBeFalse() {
        Box box = new Box(5, 10);
        boolean exist = box.isExist();
        assertThat(exist).isFalse();
    }

    @Test
    void whenVertexIsEightAndEdgeIsTenThenShouldBeSixHundred() {
        Box box = new Box(8, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(600, withPrecision(0.01d));
    }

    @Test
    void whenVertexIsThreeThenShouldBeZero() {
        Box box = new Box(3, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(0, withPrecision(0.01d));
    }


}