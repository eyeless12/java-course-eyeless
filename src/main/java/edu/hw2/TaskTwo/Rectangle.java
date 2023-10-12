package edu.hw2.TaskTwo;

public class Rectangle {
    public Rectangle(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.height = height;
    }

    private final int width;
    private final int height;


    public final int getWidth() {
        return width;
    }

    public final int getHeight() {
        return height;
    }

    public double area() {
        return width * height;
    }
}
