package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColorTest {

    @Test
    public void testValidColorWithAlpha() {
        Color color = new Color(255, 0, 0, 255);

        assertEquals(255, color.red());
        assertEquals(0, color.green());
        assertEquals(0, color.blue());
        assertEquals(255, color.alpha());
    }

    @Test
    public void testValidColorWithoutAlpha() {
        Color color = new Color(255, 0, 0);

        assertEquals(255, color.red());
        assertEquals(0, color.green());
        assertEquals(0, color.blue());
        assertEquals(255, color.alpha());
    }

    @Test
    public void testInvalidRedValue() {
        assertThrows(IllegalArgumentException.class, () -> new Color(256, 0, 0, 255));
        assertThrows(IllegalArgumentException.class, () -> new Color(-1, 0, 0, 255));
    }

    @Test
    public void testInvalidGreenValue() {
        assertThrows(IllegalArgumentException.class, () -> new Color(0, 256, 0, 255));
        assertThrows(IllegalArgumentException.class, () -> new Color(0, -1, 0, 255));
    }

    @Test
    public void testInvalidBlueValue() {
        assertThrows(IllegalArgumentException.class, () -> new Color(0, 0, 256, 255));
        assertThrows(IllegalArgumentException.class, () -> new Color(0, 0, -1, 255));
    }

    @Test
    public void testInvalidAlphaValue() {
        assertThrows(IllegalArgumentException.class, () -> new Color(0, 0, 0, 256));
        assertThrows(IllegalArgumentException.class, () -> new Color(0, 0, 0, -1));
    }
}
