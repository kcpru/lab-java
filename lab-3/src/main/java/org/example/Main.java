package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Color red = new Color(255, 0, 0);
        Shape rectangle = new Rectangle(5.0, 3.0, red);
        Shape triangle = new Triangle(6.0, 5.0, 6.0, new Color(0, 255, 0, 128));

        ShapeDescriber describer = new ShapeDescriber();
        describer.describe(rectangle);
        describer.describe(triangle);

        ShapeRenderer renderer = new ShapeRenderer();
        renderer.renderShapes(List.of(rectangle, triangle));
    }
}
