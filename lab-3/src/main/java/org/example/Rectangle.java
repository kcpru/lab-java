package org.example;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height, Color color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String getColorDescription() {
        return super.getColorDescription();
    }

    @Override
    public void draw() {
        int w = (int) Math.round(getWidth());
        int h = (int) Math.round(getHeight());

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(getAnsiColor() + "*" + "\u001B[0m");
            }
            System.out.println();
        }
    }
}
