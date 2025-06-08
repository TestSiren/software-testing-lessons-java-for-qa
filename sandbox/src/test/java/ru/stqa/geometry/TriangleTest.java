package ru.stqa.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    Triangle triangle1 = new Triangle(5.0, 6.0, 7.0);

    @Test
    public void calculateTriangle() {
        triangle1.printInfoTriangle();
    }

    /*
    3. Сделать тесты, которые проверяют,
    что реализованные методы правильно работают
    (на "хороших" данных, которые соответствуют корректным треугольникам).
     */
    @Test
    public void testPerimeter() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        double expectedPerimeter = 3.0 + 4.0 + 5.0;
        assertEquals(expectedPerimeter, triangle.perimetr());
    }

    @Test
    public void testSemiPerimeter() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        double expectedSemiPerimeter = (3.0 + 4.0 + 5.0) / 2;
        assertEquals(expectedSemiPerimeter, triangle.semiPerimetr());
    }

    @Test
    public void testAreaHeron() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        double expectedArea = 6.0;
        assertEquals(expectedArea, triangle.areaHeron());
    }
//    Triangle triangle1 = new Triangle(5.0, 6.0, 7.0);
    @Test
    public void correctEqualsTriangles() {        Triangle triangle2 = new Triangle(7.0, 5.0, 6.0);
        Triangle triangle3 = new Triangle(6.0, 7.0, 5.0);
        Triangle triangle4 = new Triangle(5.0, 6.0, 7.0);
        System.out.println("equals: " + triangle1.equals(triangle2));
        System.out.println("equals: " + triangle1.equals(triangle3));
        System.out.println("equals: " + triangle1.equals(triangle4));
    }
}
