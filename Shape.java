import java.awt.Color;



//represent the properties of the shapes

public class Shape {
    private String shape;
    private Color color;
    private int size;
    private int x;
    private int y;

    public Shape(String shape, Color color, int size, int x, int y) {
        this.shape = shape;
        this.color = color;
        this.size = size;
        this.x = x;
        this.y = y;
    }

    public String getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}