package org.example;

import java.util.List;

public class ShapeRenderer {
    public void renderShapes(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println("Rendering shape: " + shape.getClass().getSimpleName());
            System.out.println(shape.getColorDescription());
        }
    }
}
