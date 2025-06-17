/**********************************************
 Assignment #2
 Course: Data Structures & Algorithms
 Last Name: Le
 First Name: Hao
 ID: N01605830
 Section: CPAN-211-0NA
 This assignment represents my own work in accordance with Humber Academic Policy.
 Hao
 Date: June 16, 2025
 **********************************************/
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
