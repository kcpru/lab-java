package org.example;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Shape {
    @Embedded
    private Color color;

    public abstract double getArea();
    public abstract double getPerimeter();

    public Shape() {
        this(new Color(0, 0, 0));
    }

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Color setColor(Color color) {
        return color;
    }

    public String getColorDescription() {
        return String.format("Red: %d, Green: %d, Blue: %d, Alpha: %d",
                color.red(), color.green(), color.blue(), color.alpha());
    }

    public String getAnsiColor() {
        return String.format("\u001B[38;2;%d;%d;%dm", color.red(), color.green(), color.blue());
    }
}