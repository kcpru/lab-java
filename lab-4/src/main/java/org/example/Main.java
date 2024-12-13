package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        ShapeDAO shapeDAO = new ShapeDAO(sessionFactory);

        Shape rectangle = new Rectangle(5.0, 3.0, new Color(255, 0, 0));
        Shape triangle = new Triangle(6.0, 5.0, 6.0, new Color(0, 255, 0, 128));

        shapeDAO.saveShape(rectangle);
        shapeDAO.saveShape(triangle);

        List<Rectangle> rectangles = shapeDAO.getAllRectangles();
        List<Triangle> triangles = shapeDAO.getAllTriangles();

        ShapeDescriber.describe(rectangles.getFirst());
        ShapeDescriber.describe(triangles.getFirst());

        sessionFactory.close();
    }
}
