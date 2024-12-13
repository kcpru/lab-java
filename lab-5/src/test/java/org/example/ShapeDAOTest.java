package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeDAOTest {
    private ShapeDAO shapeDAO;

    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.test.cfg.xml")
            .buildSessionFactory();

    @BeforeEach
    public void setup() {
        shapeDAO = new ShapeDAO(sessionFactory);
        shapeDAO.deleteAllShapes();
    }

    @AfterEach
    void tearDown() {
        sessionFactory.close();
    }

    @Test
    public void testIfTablesWereCreatedSuccessfully() {
        assertTrue(shapeDAO.getAllRectangles().isEmpty(), "rectangle table should be empty!");
        assertTrue(shapeDAO.getAllTriangles().isEmpty(), "triangle table should be empty!");
    }

    @Test
    public void testIfRectangleObjectIsSavedToDatabase() {
        Color color = new Color(255, 125, 20, 255);
        Rectangle rectangle = new Rectangle(5.0, 10.0, color);

        shapeDAO.saveShape(rectangle);

        List<Rectangle> rectangles = shapeDAO.getAllRectangles();

        assertEquals(1, rectangles.size(), "rectangle table should contain exactly one record!");

        Rectangle loadedRectangle = rectangles.getFirst();
        assertEquals(10.0, loadedRectangle.getHeight());
        assertEquals(5.0, loadedRectangle.getWidth());
        assertEquals(color, loadedRectangle.getColor());
    }

    @Test
    public void testIfTriangleObjectIsSavedToDatabase() {
        Color redColor = new Color(255, 0, 0, 255);

        Triangle triangle1 = new Triangle(1, 2, 3, redColor);
        Triangle triangle2 = new Triangle(3, 2, 1, redColor);

        shapeDAO.saveShape(triangle1);
        shapeDAO.saveShape(triangle2);

        List<Triangle> triangles = shapeDAO.getAllTriangles();
        assertEquals(2, triangles.size(), "triangle table should contain exactly two records!");

        Triangle loadedTriangle1 = triangles.getFirst();
        assertEquals(redColor, loadedTriangle1.getColor());
        assertEquals(1.0, loadedTriangle1.getSideA());
        assertEquals(2.0, loadedTriangle1.getSideB());
        assertEquals(3.0, loadedTriangle1.getSideC());

        Triangle loadedTriangle2 = triangles.get(1);
        assertEquals(redColor, loadedTriangle2.getColor());
        assertEquals(3.0, loadedTriangle2.getSideA());
        assertEquals(2.0, loadedTriangle2.getSideB());
        assertEquals(1.0, loadedTriangle2.getSideC());
    }
}