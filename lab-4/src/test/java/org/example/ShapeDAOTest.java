package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeDAOTest {
    private static SessionFactory sessionFactory;
    private static ShapeDAO shapeDAO;

    @BeforeAll
    public static void setup() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        shapeDAO = new ShapeDAO(sessionFactory);
    }

    @Test
    public void testSaveAndRetrieveRectangle() {
        Rectangle rectangle = new Rectangle(5.0, 3.0, new Color(255, 0, 0));
        shapeDAO.saveShape(rectangle);

        var shapes = shapeDAO.getAllShapes();
        assertEquals(1, shapes.size());
    }

    @AfterAll
    public static void cleanup() {
        sessionFactory.close();
    }
}

