package ru.stqa.geometry;
/*
1. Создать класс Triangle для представления треугольников.
Объекты этого класса должны содержать три свойства,
которые соответствуют длинам сторон треугольника.

2. Реализовать методы для вычисления периметра и площади треугольника
(для вычисления площади можно использовать формулу Герона).
 */

public class Triangle {
    public double sideA;
    public double sideB;
    public double sideC;

    public Triangle(double sideA, double sideB, double sideC){
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
}
