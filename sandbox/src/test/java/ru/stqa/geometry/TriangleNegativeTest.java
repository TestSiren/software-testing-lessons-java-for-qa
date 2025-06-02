package ru.stqa.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void sideAequalsSideB()
    {
        Triangle triangle = new Triangle(3.0, 3.0, 5.0);
    }

    @Test
    public void sideAequalsSideC()
    {
        Triangle triangle = new Triangle(5.0, 3.0, 5.0);
    }

    @Test
    public void sideBequalsSideC()
    {
        Triangle triangle = new Triangle(3.0, 2.0, 2.0);
    }

}
