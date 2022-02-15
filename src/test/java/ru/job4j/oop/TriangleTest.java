package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        Assert.assertEquals(8, rsl, 0.001);
    }

    @Test
    public void when00and02and04ThenMinus1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        Assert.assertEquals(-1, rsl, 0.001);
    }
}