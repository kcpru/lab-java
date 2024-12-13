package org.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShapeService {
    private final RectangleRepository rectangleRepository;
    private final TriangleRepository triangleRepository;

    public ShapeService(RectangleRepository rectangleRepository, TriangleRepository triangleRepository) {
        this.rectangleRepository = rectangleRepository;
        this.triangleRepository = triangleRepository;
    }

    public List<Shape> getAllShapes() {
        List<Rectangle> rectangles = getAllRectangles();
        List<Triangle> triangles = getAllTriangles();

        List<Shape> shapes = new ArrayList<>();
        shapes.addAll(rectangles);
        shapes.addAll(triangles);

        return shapes;
    }

    public List<Rectangle> getAllRectangles() {
        return rectangleRepository.findAll();
    }

    public List<Triangle> getAllTriangles() {
        return triangleRepository.findAll();
    }

    public Rectangle getRectangle(Long id) {
        return rectangleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Rectangle not found"));
    }

    public Triangle getTriangle(Long id) {
        return triangleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Triangle not found"));
    }

    public Long addRectangle(Rectangle rectangle) {
        return rectangleRepository.save(rectangle).getId();
    }

    public Long addTriangle(Triangle triangle) {
        return triangleRepository.save(triangle).getId();
    }

    public boolean doesRectangleExist(Long id) {
        return rectangleRepository.existsById(id);
    }

    public boolean doesTriangleExist(Long id) {
        return triangleRepository.existsById(id);
    }

    public void deleteRectangle(Long id) {
        rectangleRepository.deleteById(id);
    }

    public void deleteTriangle(Long id) {
        triangleRepository.deleteById(id);
    }
}