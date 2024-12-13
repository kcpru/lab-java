package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeRendererTest {

    @Test
    public void testRenderShapes() {
        Color red = new Color(255, 0, 0);
        Color blue = new Color(0, 0, 255);

        Shape rectangle = new Rectangle(5.0, 3.0, red);
        Shape triangle = new Triangle(3.0, 4.0, 5.0, blue);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        ShapeRenderer renderer = new ShapeRenderer();

        renderer.renderShapes(List.of(rectangle, triangle));

        String output = outputStream.toString();

        assertTrue(output.contains("Rendering shape: Rectangle"));
        assertTrue(output.contains("Red: 255, Green: 0, Blue: 0, Alpha: 255"));
        assertTrue(output.contains("Rendering shape: Triangle"));
        assertTrue(output.contains("Red: 0, Green: 0, Blue: 255, Alpha: 255"));
    }
}
