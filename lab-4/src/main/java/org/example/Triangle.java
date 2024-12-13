package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "triangle")
public class Triangle extends Shape {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private double sideA;

    @Column
    private double sideB;

    @Column
    private double sideC;

    public Triangle() { }

    public Triangle(double sideA, double sideB, double sideC, Color color) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

//    @Override
//    public void draw() {
//        double a = getSideA();
//        double b = getSideB();
//
//        int base = (int) Math.round(a);
//        int height = (int) Math.round(b);
//
//        int rows = Math.max(base, height);
//        for (int i = 1; i <= rows; i++) {
//            String spaces = " ".repeat(rows - i);
//            String stars = "*".repeat(i * 2 - 1);
//            System.out.println(getAnsiColor() + spaces + stars + "\u001B[0m");
//        }
//    }
}
