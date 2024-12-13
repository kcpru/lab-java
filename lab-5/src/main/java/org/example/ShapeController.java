package org.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ShapeController {
    private final ShapeService shapeService;

    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

    @GetMapping
    @RequestMapping("api/shape")
    public List<Shape> getAllShapes() {
        return shapeService.getAllShapes();
    }

    @GetMapping
    @RequestMapping("api/rectangle")
    public List<Rectangle> getAllRectangles() {
        return shapeService.getAllRectangles();
    }

    @GetMapping
    @RequestMapping("api/triangle")
    public List<Triangle> getAllTriangles() {
        return shapeService.getAllTriangles();
    }

    @GetMapping
    @RequestMapping("api/rectangle/{id}")
    public Rectangle getRectangle(@PathVariable Long id) {
        return shapeService.getRectangle(id);
    }

    @GetMapping
    @RequestMapping("api/triangle/{id}")
    public Triangle getTriangle(@PathVariable Long id) {
        return shapeService.getTriangle(id);
    }

    @PutMapping
    @RequestMapping("api/rectangle/add")
    public Long addRectangle(@RequestBody Rectangle rectangle) {
        return shapeService.addRectangle(rectangle);
    }

    @PutMapping
    @RequestMapping("api/triangle/add")
    public Long addTriangle(@RequestBody Triangle triangle) {
        return shapeService.addTriangle(triangle);
    }

    @DeleteMapping
    @RequestMapping("api/rectangle/delete")
    public void removeRectangle(@RequestParam Long id) {
        if (!shapeService.doesRectangleExist(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Rectangle with id " + id + " not found"
            );
        }

        shapeService.deleteRectangle(id);
    }

    @DeleteMapping
    @RequestMapping("api/triangle/delete")
    public void removeTriangle(@RequestParam Long id) {
        if (!shapeService.doesTriangleExist(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Triangle with id " + id + " not found"
            );
        }

        shapeService.deleteTriangle(id);
    }
}