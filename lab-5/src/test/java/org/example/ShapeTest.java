package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {

    @Test
    public void testColorDescription() {
        Color red = new Color(255, 0, 0);
        Shape rectangle = new Rectangle(5.0, 3.0, red);

        String expectedDescription = "Red: 255, Green: 0, Blue: 0, Alpha: 255";
        assertEquals(expectedDescription, rectangle.getColorDescription());
    }

    @Test
    public void testAnsiColor() {
        Color blue = new Color(0, 0, 255);
        Shape rectangle = new Rectangle(5.0, 3.0, blue);

        String expectedAnsiColor = "\u001B[38;2;0;0;255m";
        assertEquals(expectedAnsiColor, rectangle.getAnsiColor());
    }

    @Test
    public void testColorInheritance() {
        Color green = new Color(0, 255, 0);
        Shape triangle = new Triangle(3.0, 4.0, 5.0, green);

        assertEquals(green, triangle.getColor());
    }

    @Test
    public void testColorDescriptionForDifferentShapes() {
        Color red = new Color(255, 0, 0);
        Shape rectangle = new Rectangle(5.0, 3.0, red);
        Shape triangle = new Triangle(3.0, 4.0, 5.0, red);

        String expectedDescription = "Red: 255, Green: 0, Blue: 0, Alpha: 255";
        assertEquals(expectedDescription, rectangle.getColorDescription());
        assertEquals(expectedDescription, triangle.getColorDescription());
    }
}
