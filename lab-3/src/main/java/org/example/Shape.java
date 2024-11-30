package org.example;

public abstract class Shape {
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void draw();

    private final Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
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