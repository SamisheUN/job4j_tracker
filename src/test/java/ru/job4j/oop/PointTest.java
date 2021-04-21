package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void point2DTest() {
        Point pointOne = new Point(0, 0);
        Point pointTwo = new Point(0, 1);
        double result = pointOne.distance(pointTwo);
        assertThat(result, closeTo(1, 0.001));
    }

    @Test
    public void point3DTest() {
        Point pointOne = new Point(0, 0, 0);
        Point pointTwo = new Point(0, 1, 0);
        double result = pointOne.distance3d(pointTwo);
        assertThat(result, closeTo(1, 0.001));
    }

}
