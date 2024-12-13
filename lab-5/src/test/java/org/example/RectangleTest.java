package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {
    @Test
    public void testRectangle() {
        Color red = new Color(255, 0, 0);
        Rectangle rectangle = new Rectangle(5.0, 3.0, red);

        assertEquals(5.0, rectangle.getWidth());
        assertEquals(3.0, rectangle.getHeight());
        assertEquals(15.0, rectangle.getArea());
        assertEquals(16.0, rectangle.getPerimeter());
    }

    @Test
    public void testRectangleColor() {
        Color red = new Color(255, 0, 0);
        Rectangle rectangle = new Rectangle(5.0, 3.0, red);

        assertEquals("Red: 255, Green: 0, Blue: 0, Alpha: 255", rectangle.getColorDescription());
    }

    @Test
    public void testRectangleAnsiColor() {
        Color red = new Color(255, 0, 0);
        Rectangle rectangle = new Rectangle(5.0, 3.0, red);

        assertEquals("\u001B[38;2;255;0;0m", rectangle.getAnsiColor());
    }

    @Test
    public void testRectangleColorInherited() {
        Color red = new Color(255, 0, 0);
        Rectangle rectangle = new Rectangle(5.0, 3.0, red);

        assertEquals(red, rectangle.getColor());
    }
}