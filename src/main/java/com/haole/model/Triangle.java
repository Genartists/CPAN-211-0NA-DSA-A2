package model;

public class Triangle {
    private final double side1, side2, side3;
    private String color;
    private boolean filled;

    public Triangle(double side1, double side2, double side3) throws TriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new TriangleException("Sides must be positive numbers.");
        }
        if (!isValid(side1, side2, side3)) {
            throw new TriangleException("The given sides do not form a valid triangle.");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    private boolean isValid(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public double getArea() {
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getSide1() { return side1; }
    public double getSide2() { return side2; }
    public double getSide3() { return side3; }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }
}

