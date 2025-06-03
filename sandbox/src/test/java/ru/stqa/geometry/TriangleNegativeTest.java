package ru.stqa.geometry;

import org.junit.jupiter.api.Test;

public class TriangleNegativeTest {
    @Test
            public void sideAEqualsZero() {
        Triangle triangle = new Triangle(0.0, 6.0, 7.0);
    }

    @Test
    public void sideBEqualsNegative() {
        Triangle triangle = new Triangle(2.0, -6.0, 7.0);
    }

    @Test
    public void sideCEqualsNegative() {
        Triangle triangle = new Triangle(2.0, 6.0, -0.1);
    }

    @Test
    public void sideAMoreOtherSides()
    {
        Triangle triangle = new Triangle(200.0, 6.0, 7.0);
    }
    @Test
    public void sideBMoreOtherSides()
    {
        Triangle triangle = new Triangle(1.0, 3.1, 2.0);
    }
    @Test
    public void sideCMoreOtherSides()
    {
        Triangle triangle = new Triangle(1.0, 3.1, 5.0);
    }
    @Test
    public void correctEqualsTriangles() {
        Triangle triangle1 = new Triangle(5.0, 6.0, 7.0);
        Triangle triangle2 = new Triangle(5.1, 5.0, 6.0);
        Triangle triangle3 = new Triangle(5.0, 6.1, 7.0);
        Triangle triangle4 = new Triangle(5.0, 6.0, 7.1);
        System.out.println("equals: " + triangle1.equals(triangle2));
        System.out.println("equals: " + triangle1.equals(triangle3));
        System.out.println("equals: " + triangle1.equals(triangle4));
    }
}
