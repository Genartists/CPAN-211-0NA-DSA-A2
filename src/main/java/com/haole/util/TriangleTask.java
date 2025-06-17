package com.haole.util;

import com.haole.model.Triangle;
import javafx.concurrent.Task;

public class TriangleTask extends Task<String> {
    private Triangle triangle;

    public TriangleTask(Triangle triangle) {
        this.triangle = triangle;
    }
    @Override
    protected String call() throws Exception {
        double area = triangle.getArea();
        double perimeter = triangle.getPerimeter();
        String color = triangle.getColor();
        boolean filled = triangle.isFilled();

        return String.format(
                "Result:\n" +
                        "Area: %.2f\n" +
                        "Perimeter: %.2f\n" +
                        "Color: %s\n" +
                        "Filled: %b",
                area, perimeter, color, filled
        );    }
}
