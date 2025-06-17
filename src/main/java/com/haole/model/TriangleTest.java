package model;

public class TriangleTest {
    public static void main(String[] args) {
        try {
            Triangle t = new Triangle(3, 4, 5);
            System.out.println("Area: " + t.getArea());
            System.out.println("Perimeter: " + t.getPerimeter());
        } catch (TriangleException e) {
            System.out.println("Triangle error: " + e.getMessage());
        }

        try {
            Triangle invalid = new Triangle(1, 2, 10);
        } catch (TriangleException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}
