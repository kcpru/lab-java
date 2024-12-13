package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    public void testTriangle() {
        Color green = new Color(0, 255, 0);
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, green);

        assertEquals(3.0, triangle.getSideA());
        assertEquals(4.0, triangle.getSideB());
        assertEquals(5.0, triangle.getSideC());

        assertEquals(6.0, triangle.getArea(), 0.01);

        assertEquals(12.0, triangle.getPerimeter());
    }

    @Test
    public void testTriangleColor() {
        Color green = new Color(0, 255, 0);
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, green);

        assertEquals("Red: 0, Green: 255, Blue: 0, Alpha: 255", triangle.getColorDescription());
    }

    @Test
    public void testTriangleDraw() {
        Color green = new Color(0, 255, 0);
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, green);

        triangle.draw();
    }

    @Test
    public void testTriangleAnsiColor() {
        Color green = new Color(0, 255, 0);
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, green);

        assertEquals("\u001B[38;2;0;255;0m", triangle.getAnsiColor());
    }

    @Test
    public void testTriangleColorInherited() {
        Color green = new Color(0, 255, 0);
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, green);

        assertEquals(green, triangle.getColor());
    }
}
