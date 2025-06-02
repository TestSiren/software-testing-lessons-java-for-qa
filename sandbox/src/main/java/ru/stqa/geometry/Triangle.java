package ru.stqa.geometry;
/*
1. Создать класс Triangle для представления треугольников.
Объекты этого класса должны содержать три свойства,
которые соответствуют длинам сторон треугольника.

2. Реализовать методы для вычисления периметра и площади треугольника
(для вычисления площади можно использовать формулу Герона).
 */

import java.util.Objects;

public class Triangle {
    public double sideA;
    public double sideB;
    public double sideC;

    public Triangle(double sideA, double sideB, double sideC){
        /* Доработайте конструктор в классе Triangle, чтобы он выбрасывал исключение
         при попытке создать треугольник с отрицательной длиной стороны, а также
         в том случае, если нарушается неравенство треугольника
         (сумма двух любых сторон должна быть не меньше третьей стороны).
        */
        if ((sideA <= 0) || (sideB <= 0) || (sideC <= 0)) {
            throw new IllegalArgumentException("All sides must be positive and more than zero");
        } else if ((sideA + sideB <= sideC) ||
                (sideA + sideC <= sideB) ||
                (sideB + sideC <= sideA)) {
            throw new IllegalArgumentException("The sum of any two sides must be greater than the third");
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double perimetr(){
        return sideA+sideB+sideC;
    }

    public double semiPerimetr(){
        return perimetr()/2;
    }

    public double areaHeron()
    {
        double s = semiPerimetr();
        double area = Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
        return area;
    }

    public void printInfoTriangle() {
        System.out.println(
                "Сторона А:" + sideA +
        "\nСторона B:" + sideB +
        "\nСторона C:" + sideC +
        "\nПериметр:" + perimetr() +
        "\nПлощадь по формуле Герона:" + areaHeron()
        );
    }

    /*
    Реализуйте тесты для сравнения треугольников (класс Triangle).
    Доработайте функцию equals в этом классе, чтобы треугольники с одинаковыми сторонами считались равными
    , независимо от порядка сторон (то есть, например, треугольник со сторонами 3, 4, 5
    должен считаться равным треугольнику со сторонами 4, 5, 3).
     */

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        if (Double.compare(sideA, triangle.sideA) == 0 &&
                Double.compare(sideB, triangle.sideB) == 0 &&
                Double.compare(sideC, triangle.sideC) == 0) {
            return true;
        } else if (Double.compare(sideA, triangle.sideA) == 0 &&
                Double.compare(sideB, triangle.sideC) == 0 &&
                Double.compare(sideC, triangle.sideB) == 0) {
            return true;
        } else if (Double.compare(sideA, triangle.sideB) == 0 &&
                Double.compare(sideB, triangle.sideA) == 0 &&
                Double.compare(sideC, triangle.sideC) == 0) {
            return true;
        } else if (Double.compare(sideA, triangle.sideB) == 0 &&
                Double.compare(sideB, triangle.sideC) == 0 &&
                Double.compare(sideC, triangle.sideA) == 0) {
            return true;
        } else if (Double.compare(sideA, triangle.sideC) == 0 &&
                Double.compare(sideB, triangle.sideA) == 0 &&
                Double.compare(sideC, triangle.sideB) == 0) {
            return true;
        } else if (Double.compare(sideA, triangle.sideC) == 0 &&
                Double.compare(sideB, triangle.sideB) == 0 &&
                Double.compare(sideC, triangle.sideA) == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB, sideC);
    }
}
